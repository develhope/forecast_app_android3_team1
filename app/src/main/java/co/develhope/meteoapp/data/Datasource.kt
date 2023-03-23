package co.develhope.meteoapp.data

import co.develhope.meteoapp.MeteoApp
import co.develhope.meteoapp.data.domainmodel.Place
import org.threeten.bp.OffsetDateTime


object Datasource {
    private var selectedPlace : Place? = null
    fun savePlace(place: Place){
        selectedPlace = place
        recentSearchList.add(place)
    }

   // fun getPlace() : Place? = selectedPlace

    fun getPlace() : Place? {
        return MeteoApp.preferences?.getCurrentPlace()
    }




    private val recentSearchList = mutableListOf<Place>()

    fun loadRecentSearch() : List<Place> {
        return recentSearchList
    }

    fun addToRecentSearch(place : Place){
        recentSearchList.add(place)
    }

    fun getSelectedDate() = OffsetDateTime.now()
    fun getTime(): OffsetDateTime = OffsetDateTime.now()

}