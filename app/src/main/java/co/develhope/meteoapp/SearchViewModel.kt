package co.develhope.meteoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.network.NetworkProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel : ViewModel() {

    private var _placeLocation = MutableLiveData<List<Place>>()
    val placeLocation : LiveData<List<Place>> = _placeLocation



    fun searchNetworkCall(location : String, language:  String)  {
        GlobalScope.launch (Dispatchers.IO){
            val results = NetworkProvider().provideGeocodingService().getCityInfo(location, language)
            withContext(Dispatchers.Main){
                if(results.results != null){

                    _placeLocation.value = results.toDomain()
                }
            }
        }
    }
}