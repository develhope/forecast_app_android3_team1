package co.develhope.meteoapp.data


import co.develhope.meteoapp.model.RecyclerViewData


object RecentSearchDataSet {


        private val recentSearchList = mutableListOf(
           RecyclerViewData.RecentSearchTitle("Recent Search"),
            RecyclerViewData.RecentSearch("Palermo"),
            RecyclerViewData.RecentSearch("Catanzaro"),
            RecyclerViewData.RecentSearch("Roma"),
            RecyclerViewData.RecentSearch("Milano")
        )

        fun loadRecentSearch() : List<RecyclerViewData> {
            return recentSearchList
        }

}