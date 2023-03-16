package co.develhope.meteoapp.data.domainmodel

import org.threeten.bp.OffsetDateTime


data class RowForecast(
    val time: OffsetDateTime,
    val weatherCondition: WeatherCondition,
    val humidity: Double,
    val temp: Double
)