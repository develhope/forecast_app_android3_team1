package co.develhope.meteoapp.network.dto


import com.google.gson.annotations.SerializedName
import org.threeten.bp.OffsetDateTime

data class Hourly(
    @SerializedName("rain")
    val rain: List<Int>,
    @SerializedName("showers")
    val showers: List<Double>,
    @SerializedName("snowfall")
    val snowfall: List<Int>,
    @SerializedName("temperature_2m")
    val temperature2m: List<Double>,
    @SerializedName("time")
    val time: List<OffsetDateTime>,
    @SerializedName("weathercode")
    val weathercode: List<Int>,
    @SerializedName("windspeed_10m")
    val windspeed10m: List<Double>,
    @SerializedName("relativehumidity_2m")
    val humidity : List<Double>,
    @SerializedName("cloudcover")
    val cloudcover : List<Double>,
    @SerializedName("apparent_temperature")
    val apparenttemperature : List<Double>
)