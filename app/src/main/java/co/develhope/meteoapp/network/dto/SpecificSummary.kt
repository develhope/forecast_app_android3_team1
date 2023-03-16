package co.develhope.meteoapp.network.dto


import co.develhope.meteoapp.data.domainmodel.*
import co.develhope.meteoapp.ui.utils.decodeWMO
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

    fun toDomain(): List<SpecyficDayForecastSummary> {
        return this.hourly.time.mapIndexed { i, date ->
            SpecyficDayForecastSummary(
                row = RowForecast(
                    time = date,
                    weatherCondition = decodeWMO(hourly.weathercode[i]),
                    humidity = hourly.humidity[i],
                    temp = hourly.temperature2m[i]
                ), card = CardForecast(
                    percepita = hourly.apparenttemperature[i],
                    humidity = hourly.humidity[i],
                    copertura = hourly.cloudcover[i],
                    uv = 7.0,
                    vento = hourly.windspeed10m[i],
                    pioggia = hourly.rain[i].toInt(),
                ))
        }
    }

    //da modificare appena ci saranno più icone per gestire tutti i codic

}