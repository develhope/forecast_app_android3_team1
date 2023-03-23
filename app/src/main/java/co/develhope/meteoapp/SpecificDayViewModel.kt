package co.develhope.meteoapp

import androidx.lifecycle.*
import co.develhope.meteoapp.data.Datasource.getPlace
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.data.domainmodel.SpecyficDayForecastSummary

import co.develhope.meteoapp.network.NetworkProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.OffsetDateTime

class SpecificDayViewModel: ViewModel() {

    private var _specificDayForecastList: MutableLiveData<List<SpecyficDayForecastSummary>> = MutableLiveData()
    val specificDayForecastList: LiveData<List<SpecyficDayForecastSummary>>
        get() = _specificDayForecastList

    private fun getSpecificSummary(place: Place, dateTime: OffsetDateTime) {
        viewModelScope.launch(Dispatchers.Main) {
            val result = NetworkProvider().getSpecificSummary(
                getPlace()!!.lat,
                getPlace()!!.log,
                startDate = dateTime,
                endDate = dateTime
            )
            val hourlyForecast: List<SpecyficDayForecastSummary> = result.toDomain()

            withContext(Dispatchers.Main) {
                _specificDayForecastList.value = hourlyForecast
            }
        }
    }
}
