package co.develhope.meteoapp.model

sealed class RecyclerViewData {

    data class RecentSearchTitle(val title : String) : RecyclerViewData ()
    data class RecentSearch(val cityName: String) : RecyclerViewData()
}
