package co.develhope.meteoapp.network.dto


import co.develhope.meteoapp.data.domainmodel.*
import com.google.gson.annotations.SerializedName

data class SpecificSummary(
    @SerializedName("current_weather")
    val currentWeather: CurrentWeather,
    @SerializedName("elevation")
    val elevation: Int,
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double,
    @SerializedName("hourly")
    val hourly: Hourly,
    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnits,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String,
    @SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int
) {

    fun toDomainRow(): List<RowForecast> {
        return this.hourly.time.mapIndexed { i, date ->
            RowForecast(
                time = hourly.time[i].toInt(),
                weatherCondition = weaterDecode(hourly.weathercode[i]),
                humidity = hourly.snowfall[i],
                temp = hourly.temperature2m[i].toInt()
            )
        }
    }

    //da modificare appena ci saranno più icone per gestire tutti i codic
    private fun weaterDecode(weatherCode: Int): WeatherCondition {
        return when (weatherCode) {
            in 59..69 -> return WeatherCondition.RAIN
            in 40..50 -> return WeatherCondition.FOG
            else -> WeatherCondition.SUNNY
        }
    }

    fun toDomainCard(): List<CardForecast> {
        return this.hourly.time.mapIndexed { i, date ->
            CardForecast(
                percepita = hourly.showers[i],
                humidity = hourly.snowfall[i],
                copertura = hourly.weathercode[i],
                uv = hourly.weathercode[i],
                vento = hourly.windspeed10m[i].toInt(),
                pioggia = hourly.rain[i],
            )
        }
    }
}