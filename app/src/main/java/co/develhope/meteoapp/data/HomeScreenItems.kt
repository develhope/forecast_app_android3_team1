package co.develhope.meteoapp.data

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