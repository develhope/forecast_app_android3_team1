package co.develhope.meteoapp.data.domainmodel

import org.threeten.bp.OffsetDateTime

data class Forecast(
    val minTemp: Int,
    val maxTemp: Int,
    val rainfall: Int,
    val wind: Int,
    val weatherCondition: WeatherCondition,
    val date: OffsetDateTime
)