package co.develhope.meteoapp.data


import co.develhope.meteoapp.ui.adapter.searchscreen.SearchScreenItems


object RecentSearchDataSet {


        private val recentSearchList = mutableListOf(
            SearchScreenItems.RecentSearchTitle("Recent Search"),
            SearchScreenItems.RecentSearch("Palermo"),
            SearchScreenItems.RecentSearch("Catanzaro"),
            SearchScreenItems.RecentSearch("Roma"),
            SearchScreenItems.RecentSearch("Milano")
        )

        fun loadRecentSearch() : List<SearchScreenItems> {
            return recentSearchList
        }

}