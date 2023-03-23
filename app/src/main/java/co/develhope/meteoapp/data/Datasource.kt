package co.develhope.meteoapp.data

import co.develhope.meteoapp.data.domainmodel.DailyForecastSummary
import co.develhope.meteoapp.data.domainmodel.Forecast
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.data.domainmodel.WeatherCondition
import org.threeten.bp.OffsetDateTime


object Datasource {
    private var selectedPlace : Place? = null
    fun savePlace(place: Place){
        selectedPlace = place
        recentSearchList.add(place)
    }

    fun getPlace() : Place? = selectedPlace




    private val recentSearchList = mutableListOf<Place>()

    fun loadRecentSearch() : List<Place> {
        return recentSearchList
    }

    fun addToRecentSearch(place : Place){
        recentSearchList.add(place)
    }



}