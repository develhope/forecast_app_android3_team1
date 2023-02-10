package co.develhope.meteoapp.data.domainmodel


data class DailyForecastSummary(
    val place: Place,
    val date: String,
    val forecast: Forecast
)