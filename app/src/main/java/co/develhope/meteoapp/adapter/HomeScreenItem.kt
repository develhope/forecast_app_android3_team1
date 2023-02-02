package co.develhope.meteoapp.adapter

import co.develhope.meteoapp.data.Data


sealed class HomeScreenItem {
    abstract val viewType: Int

    data class TitleDetail(
        val titleHomeScreen: Data.HomeScreenTitle
    ) : HomeScreenItem() {
        override val viewType = 0
    }

    data class ForecastDetail(
        val forecastDetail: Data.HourlyForecast
    ) : HomeScreenItem() {
        override val viewType = 1
    }

    data class NextDays(
        val nextDays: Data.NextDays
    ) : HomeScreenItem() {
        override val viewType = 2
    }


}
