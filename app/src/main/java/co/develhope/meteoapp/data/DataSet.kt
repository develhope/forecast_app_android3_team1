package co.develhope.meteoapp.data

import co.develhope.meteoapp.model.RecentSearch

class DataSet {

    companion object {
        private val recentSearchList = mutableListOf<RecentSearch>(
            RecentSearch("Palermo","12","Soleggiato"),
            RecentSearch("Catanzaro","16","Parz. nuvoloso"),
            RecentSearch("Roma","3","Nuvoloso")
        )

        fun loadRecentSearch() : List<RecentSearch> {
            return recentSearchList
        }
    }
}