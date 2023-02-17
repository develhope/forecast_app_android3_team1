package co.develhope.meteoapp.data.domainmodel

import java.time.OffsetDateTime

data class RowForecast(
    val time: Int,
    val weatherCondition: WeatherCondition,
    val humidity: Int,
    val temp: Int
)