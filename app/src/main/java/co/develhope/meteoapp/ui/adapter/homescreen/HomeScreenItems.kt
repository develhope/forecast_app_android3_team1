package co.develhope.meteoapp.ui.adapter.homescreen

import co.develhope.meteoapp.data.domainmodel.DailyForecastSummary
import co.develhope.meteoapp.data.domainmodel.Place

sealed class HomeScreenItems {

    abstract val type: Int

    data class HomeScreenTitle(val place: Place) : HomeScreenItems() {
        override val type: Int = 0
    }

    data class Forecast(val forecastSummary : DailyForecastSummary) : HomeScreenItems(){
        override val type: Int = 1
    }
    object NextDays : HomeScreenItems(){
        override val type: Int = 2
    }

}