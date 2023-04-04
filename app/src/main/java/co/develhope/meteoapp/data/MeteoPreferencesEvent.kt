package co.develhope.meteoapp.data

import co.develhope.meteoapp.data.domainmodel.Place

sealed class MeteoSavePreferencesEvent {

    data class SavePlaceEvent(val data : Place) : MeteoSavePreferencesEvent()
    data class SaveRecentSearchEvent(val data : List<Place>) : MeteoSavePreferencesEvent()
}

sealed class MeteoGetPreferencesEvent {
    class GetCurrentPlaceEvent() : MeteoGetPreferencesEvent()
    class GetRecentSearchEvent() : MeteoGetPreferencesEvent()
}

sealed class PlaceResources {
    data class Success(val data : Place) : PlaceResources()
    data class Failed(val message : String) : PlaceResources()

    data class ResourceSuccess(val data : List<Place>) : PlaceResources()

}


