package co.develhope.meteoapp.network.dto


import co.develhope.meteoapp.data.domainmodel.CardForecast
import co.develhope.meteoapp.data.domainmodel.Forecast
import co.develhope.meteoapp.data.domainmodel.WeatherCondition
import co.develhope.meteoapp.ui.utils.decodeWMO
import com.google.gson.annotations.SerializedName

data class HomeSummary(
    @SerializedName("current_weather")
    val currentWeather: CurrentWeather,
    @SerializedName("daily")
    val daily: Daily,
    @SerializedName("daily_units")
    val dailyUnits: DailyUnits,
    @SerializedName("elevation")
    val elevation: Int,
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double,
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
)
{
    fun toDomain() : List<Forecast> {
        return this.daily.time.mapIndexed { i, date ->
            Forecast(
                minTemp = daily.temperature2mMin[i].toInt(),
                maxTemp = daily.temperature2mMax[i].toInt(),
                rainfall = daily.rainSum[i].toInt(),
                wind = daily.windspeed[i].toInt(),
                weatherCondition = decodeWMO(daily.weathercode[i]),
                date = date
            )
        }
    }

    //da modificare appena ci saranno più icone per gestire tutti i codici


}