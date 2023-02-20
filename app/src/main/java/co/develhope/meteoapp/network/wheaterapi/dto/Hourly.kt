package co.develhope.meteoapp.network.wheaterapi.dto

data class Hourly(
    val apparent_temperature: List<Double>,
    val cloudcover: List<Int>,
    val precipitation: List<Double>,
    val rain: List<Double>,
    val relativehumidity_2m: List<Int>,
    val temperature_2m: List<Double>,
    val time: List<String>,
    val visibility: List<Double>,
    val weathercode: List<Int>,
    val windspeed_10m: List<Double>
)