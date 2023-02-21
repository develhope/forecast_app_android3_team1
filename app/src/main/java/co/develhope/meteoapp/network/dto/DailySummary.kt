package co.develhope.meteoapp.network.dto


import com.google.gson.annotations.SerializedName

data class DailySummary(
    @SerializedName("current_weather")
    val currentWeather: CurrentWeather,
    @SerializedName("elevation")
    val elevation: Double,
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double,
    @SerializedName("hourly")
    val hourly: HourlyForecast,
    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnits, //units presents  in the response (C, KMh, iso, timezone ecc)
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