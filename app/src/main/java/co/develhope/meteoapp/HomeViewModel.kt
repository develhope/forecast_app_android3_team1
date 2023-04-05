package co.develhope.meteoapp

import androidx.lifecycle.*
import co.develhope.meteoapp.data.domainmodel.DailyForecastSummary
import co.develhope.meteoapp.data.domainmodel.Forecast
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.ui.adapter.homescreen.HomeScreenItems
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private var _homeForecastList: MutableLiveData<List<DailyForecastSummary>> = MutableLiveData()
    val homeForecastList: LiveData<List<DailyForecastSummary>>
        get() = _homeForecastList

    fun getDailySummary() {
        if (MeteoApp.preferences?.getCurrentPlace() != null) {
            viewModelScope.launch {
                val result =
                    NetworkProvider().getDailySummary(MeteoApp.preferences?.getCurrentPlace()!!)

                val forecasts: List<Forecast> = result.toDomain()

                val forecastSummaryList: List<DailyForecastSummary> =
                    forecasts.mapIndexed { index, forecast ->
                        DailyForecastSummary(
                            MeteoApp.preferences?.getCurrentPlace()!!,
                            date = forecast.date,
                            forecast = forecast
                        )
                    }
                _homeForecastList.value = forecastSummaryList
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