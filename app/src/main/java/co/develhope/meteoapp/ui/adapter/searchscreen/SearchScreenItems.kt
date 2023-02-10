package co.develhope.meteoapp.ui.adapter.searchscreen

import co.develhope.meteoapp.data.domainmodel.Place

sealed class SearchScreenItems {

    data class RecentSearchTitle(val title : String) : SearchScreenItems()
    data class RecentSearch(val city: Place) : SearchScreenItems()
}
