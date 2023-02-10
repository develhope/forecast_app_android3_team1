package co.develhope.meteoapp.data.domainmodel

data class Forecast(
    val minTemp: Int,
    val maxTemp: Int,
    val rainfall: Int,
    val wind: Int,
    val weatherCondition: WeatherCondition
)