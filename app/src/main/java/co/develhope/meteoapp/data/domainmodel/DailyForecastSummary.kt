package co.develhope.meteoapp.data.domainmodel

import co.develhope.meteoapp.network.OffsetDateTimeTypeAdapter
import org.threeten.bp.OffsetDateTime
import java.time.format.DateTimeFormatter


data class DailyForecastSummary(
    val place: Place,
    val date: OffsetDateTime,
    val forecast: Forecast
)