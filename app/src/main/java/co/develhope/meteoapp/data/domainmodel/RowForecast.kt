package co.develhope.meteoapp.data.domainmodel

data class RowForecast(
    val time: Int,
    val weatherCondition: WeatherCondition,
    val humidity: Int,
    val temp: Int
)