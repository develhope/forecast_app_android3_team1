package co.develhope.meteoapp.network.wheaterapi.dto

data class HourlyUnits(
    val apparent_temperature: String,
    val cloudcover: String,
    val precipitation: String,
    val rain: String,
    val relativehumidity_2m: String,
    val temperature_2m: String,
    val time: String,
    val visibility: String,
    val weathercode: String,
    val windspeed_10m: String
)