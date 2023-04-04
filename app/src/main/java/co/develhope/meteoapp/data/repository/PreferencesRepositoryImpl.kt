package co.develhope.meteoapp.data.repository

import co.develhope.meteoapp.data.ApplicationPreferences
import co.develhope.meteoapp.data.domainmodel.Place
import javax.inject.Inject

class PreferencesRepositoryImpl @Inject constructor(
    private val preferences : ApplicationPreferences
) : PreferencesRepository {


    override fun savePlace(place: Place) {
       preferences.savePlace(place)
    }

    override fun getCurrentPlace(): Place? {
        return preferences.getCurrentPlace()
    }

    override fun loadRecentSearch(): List<Place> {
       return preferences.loadRecentSearch()
    }

    override fun saveRecentSearch(places: List<Place>) {
       preferences.saveRecentSearch(places)
    }
}