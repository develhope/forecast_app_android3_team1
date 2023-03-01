package co.develhope.meteoapp.network.dto


import co.develhope.meteoapp.data.domainmodel.Forecast
import co.develhope.meteoapp.data.domainmodel.WeatherCondition
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
    fun toForecastObjects() : List<Forecast> {
        var forecastObject = mutableListOf<Forecast>()
        for(i in 0..daily.time.size - 1){
            forecastObject.add(
                Forecast(daily.temperature2mMin[i].toInt(),
                        daily.temperature2mMax[i].toInt(),
                        daily.rainSum[i].toInt(),
                        daily.windspeed[i].toInt(),
                        decodeWMO(daily.weathercode[i])
            ))
        }
        return forecastObject
    }

    private fun decodeWMO(weatherCode : Int) : WeatherCondition {
        return when(weatherCode){
          in 59..69 -> return WeatherCondition.RAIN
            in 40..50 -> return WeatherCondition.FOG
            else -> WeatherCondition.SUNNY
        }
    }
}