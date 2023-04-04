package co.develhope.meteoapp.data.repository

import co.develhope.meteoapp.data.domainmodel.Place

interface PreferencesRepository {

    fun savePlace(place : Place)
    fun getCurrentPlace() : Place?
    fun loadRecentSearch() : List<Place>
    fun saveRecentSearch(places : List<Place>)
}