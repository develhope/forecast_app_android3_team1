package co.develhope.meteoapp.ui.adapter.searchscreen

sealed class SearchScreenItems {

    data class RecentSearchTitle(val title : String) : SearchScreenItems()
    data class RecentSearch(val cityName: String) : SearchScreenItems()
}
