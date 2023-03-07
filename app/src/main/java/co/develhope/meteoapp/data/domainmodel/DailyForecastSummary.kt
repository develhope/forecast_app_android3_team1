package co.develhope.meteoapp.data.domainmodel

import org.threeten.bp.OffsetDateTime


data class DailyForecastSummary(
    val place: Place,
    val date: OffsetDateTime,
    val forecast: Forecast
)