package co.develhope.meteoapp

import androidx.lifecycle.*
import co.develhope.meteoapp.data.Datasource
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.data.domainmodel.SpecyficDayForecastSummary
import co.develhope.meteoapp.data.domainmodel.TitleForecast
import co.develhope.meteoapp.network.NetworkProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.threeten.bp.OffsetDateTime

class SpecificDayViewModel : ViewModel() {

    private var _specificDayForecastList: MutableLiveData<List<SpecyficDayForecastSummary>> = MutableLiveData()
    val specificDayForecastList: LiveData<List<SpecyficDayForecastSummary>>
        get() = _specificDayForecastList
    private var _titleForecast: MutableLiveData<TitleForecast> = MutableLiveData()
    val titleForecast: LiveData<TitleForecast>
        get() = _titleForecast

    fun getSpecificSummary(place: Place, date: OffsetDateTime) {
        viewModelScope.launch(Dispatchers.Main) {
            val result = NetworkProvider().getSpecificSummary(
                MeteoApp.preferences?.getCurrentPlace()!!.lat,
                MeteoApp.preferences?.getCurrentPlace()!!.log,
                startDate = date,
                endDate = date
            )
            val hourlyForecast: List<SpecyficDayForecastSummary> = result.toDomain()

            withContext(Dispatchers.Main) {
                _specificDayForecastList.value = hourlyForecast
            }
        }
    }
    fun getTitleForecast(place: Place, date: OffsetDateTime) : TitleForecast{
        return   TitleForecast(
            place = place,
            date = date
        ).also {
            _titleForecast.value = it
        }
    }
}
