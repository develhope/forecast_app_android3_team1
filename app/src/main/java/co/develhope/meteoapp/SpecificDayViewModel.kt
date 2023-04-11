package co.develhope.meteoapp

import androidx.lifecycle.*
import co.develhope.meteoapp.data.Datasource
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.data.domainmodel.SpecyficDayForecastSummary
import co.develhope.meteoapp.data.domainmodel.TitleForecast
import co.develhope.meteoapp.data.repository.PreferencesRepository
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.network.SpecificWeatherResponse
import co.develhope.meteoapp.network.dto.SpecificSummary
import co.develhope.meteoapp.network.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.threeten.bp.OffsetDateTime
import javax.inject.Inject

@HiltViewModel
class SpecificDayViewModel @Inject constructor(
    private val networkRepository: NetworkRepository,
    private val preferences : PreferencesRepository
) : ViewModel() {

    private var _specificDayForecastList: MutableLiveData<List<SpecyficDayForecastSummary>> = MutableLiveData()
    val specificDayForecastList: LiveData<List<SpecyficDayForecastSummary>>
        get() = _specificDayForecastList
    private var _titleForecast: MutableLiveData<TitleForecast> = MutableLiveData()
    val titleForecast: LiveData<TitleForecast>
        get() = _titleForecast

    private var _error : MutableLiveData<java.lang.Exception> = MutableLiveData()
    val error get() = _error

    fun getSpecificSummary(place: Place, date: OffsetDateTime) {
        viewModelScope.launch(Dispatchers.Main) {
            val result = preferences.getCurrentPlace()?.let {
                networkRepository.getSpecificSummary(
                    it.lat,
                    it.log,
                    startDate = date,
                    endDate = date
                )
            }

            var hourlyForecast : List<SpecyficDayForecastSummary>? = null

            if(result is SpecificWeatherResponse.SpecificWeatherSuccess){
                hourlyForecast = result.response.toDomain()
                withContext(Dispatchers.Main) {
                    _specificDayForecastList.value = hourlyForecast!!
                }
            }else if(result is SpecificWeatherResponse.SpecificWeatherFail){
                _error.value = result.exception
            }
        }
    }

}
