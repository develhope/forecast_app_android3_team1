package co.develhope.meteoapp

import android.util.Log
import androidx.lifecycle.*
import co.develhope.meteoapp.data.MeteoGetPreferencesEvent
import co.develhope.meteoapp.data.PlaceResources
import co.develhope.meteoapp.data.domainmodel.DailyForecastSummary
import co.develhope.meteoapp.data.domainmodel.Forecast
import co.develhope.meteoapp.data.repository.PreferencesRepository
import co.develhope.meteoapp.network.HomeWeatherResponse
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.network.repository.NetworkRepository
import co.develhope.meteoapp.ui.adapter.homescreen.HomeScreenItems
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val  repository : NetworkRepository,
    private val preferences : PreferencesRepository
) : ViewModel() {
    private var _homeForecastList: MutableLiveData<List<DailyForecastSummary>> = MutableLiveData()
    val homeForecastList: LiveData<List<DailyForecastSummary>>
        get() = _homeForecastList

    private var  _error : MutableLiveData<Exception> = MutableLiveData()
    val error : LiveData<java.lang.Exception> = _error

    fun getDailySummary() {
        val currentPlace = preferences.getCurrentPlace()
        if (currentPlace != null) {
            viewModelScope.launch {
                val result = repository.getDailySummary(currentPlace)
                if(result is HomeWeatherResponse.HomeWeatherSuccess){
                    val forecasts: List<Forecast> = result.response.toDomain()
                    val forecastSummaryList: List<DailyForecastSummary> =
                        forecasts.mapIndexed { index, forecast ->
                            DailyForecastSummary(
                                preferences.getCurrentPlace()!!,
                                date = forecast.date,
                                forecast = forecast
                            )
                        }
                    _homeForecastList.value = forecastSummaryList
                }else if(result is HomeWeatherResponse.HomeWeatherFail){
                    Log.d("Network Error: ", "$result")
                    _error.value = result.response
                }
            }
        }
    }

    fun onGetPreferencesResource(event : MeteoGetPreferencesEvent) : PlaceResources {
        when(event){
            is MeteoGetPreferencesEvent.GetCurrentPlaceEvent -> {
                val preferences = preferences.getCurrentPlace()
                if(preferences != null){
                    return PlaceResources.Success(preferences)
                }else{
                    return PlaceResources.Failed("No place Saved")
                }
            }
            is MeteoGetPreferencesEvent.GetRecentSearchEvent -> {
                val resources = preferences.loadRecentSearch()
                if(resources !=  null){
                    return PlaceResources.ResourceSuccess(resources)
                }else{
                    return PlaceResources.Failed("No place list saved")
                }
            }

        }
    }

    fun createHomeScreenItems(forecastSummaryList: List<DailyForecastSummary>): List<HomeScreenItems> {
        val listToShow = mutableListOf<HomeScreenItems>()
        listToShow.add(HomeScreenItems.HomeScreenTitle(forecastSummaryList.first().place))
        listToShow.add(HomeScreenItems.Forecast(forecastSummaryList.first()))
        listToShow.add(HomeScreenItems.NextDays)

        listToShow.addAll(
            forecastSummaryList.map {
                HomeScreenItems.Forecast(it)
            }
        )
        listToShow.removeAt(3)
        listToShow.removeLast()
        return listToShow
    }


}