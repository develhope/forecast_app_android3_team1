package co.develhope.meteoapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.develhope.meteoapp.MeteoApp
import co.develhope.meteoapp.data.MeteoGetPreferencesEvent
import co.develhope.meteoapp.data.MeteoSavePreferencesEvent
import co.develhope.meteoapp.data.PlaceResources
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.data.repository.PreferencesRepository
import co.develhope.meteoapp.network.GeoResponse
import co.develhope.meteoapp.network.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository : NetworkRepository,
    private val preferences : PreferencesRepository
): ViewModel() {

    private var _placeLocation = MutableLiveData<List<Place>>()
    val placeLocation : LiveData<List<Place>> = _placeLocation

    private var _error = MutableLiveData<java.lang.Exception>()
    val error : LiveData<java.lang.Exception> = _error



    fun searchNetworkCall(location : String, language:  String)  {
        GlobalScope.launch (Dispatchers.IO){
            val results = repository.getCityInfo(location, language)
            withContext(Dispatchers.Main){
                if(results is GeoResponse.GeoSuccess && results.response.results != null){
                    Log.d("Network Response: " , "$results")
                    _placeLocation.value = results.response.toDomain()
                }else if(results is GeoResponse.GeoProblems){
                    Log.d("Network Response" , "${results.exception.message}")
                    _error.value = results.exception
                }
            }
        }
    }

    fun onPreferencesEvent(event : MeteoSavePreferencesEvent){
        when(event){
            is MeteoSavePreferencesEvent.SavePlaceEvent -> {
                preferences.savePlace(event.data)
            }
            is MeteoSavePreferencesEvent.SaveRecentSearchEvent -> {
                preferences.saveRecentSearch(event.data)
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

    fun updateRecentSearch(place: Place) {
        val list = MeteoApp.preferences?.loadRecentSearch() ?: emptyList()
        Log.d("Update", "$list")
        val newList = list.toMutableList()
        newList.add(place)
        if (newList.size > 6) {
            newList.removeFirst()
            onPreferencesEvent(MeteoSavePreferencesEvent.SaveRecentSearchEvent(newList))

            return
        }
        onPreferencesEvent(MeteoSavePreferencesEvent.SaveRecentSearchEvent(newList))
        Log.d("Updateshared", "${MeteoApp.preferences?.loadRecentSearch()}")
    }






}