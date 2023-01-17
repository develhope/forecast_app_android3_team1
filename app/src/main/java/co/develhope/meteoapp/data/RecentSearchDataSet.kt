package co.develhope.meteoapp.data

import co.develhope.meteoapp.model.RecentSearch

object RecentSearchDataSet {


        private val recentSearchList = mutableListOf<RecentSearch>(
            RecentSearch("Palermo"),
            RecentSearch("Catanzaro"),
            RecentSearch("Roma")
        )

        fun loadRecentSearch() : List<RecentSearch> {
            return recentSearchList
        }

}