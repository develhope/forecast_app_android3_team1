package co.develhope.meteoapp.ui.utils

import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.domainmodel.WeatherCondition

//set icon
fun decodeWeatherIcon(weatherCondition: WeatherCondition): Int {
    return when (weatherCondition) {
        WeatherCondition.SUNNY -> R.drawable._1_sun_light
        WeatherCondition.CLOUDY -> R.drawable._7_mostly_cloud_light
        WeatherCondition.FOG -> R.drawable._15_cloud_light
        WeatherCondition.RAIN -> R.drawable._6_rainyday_light
        WeatherCondition.SNOW -> R.drawable._22_snow_light
        WeatherCondition.HEAVYRAIN -> R.drawable._18_heavy_rain_light


    }
}

//
fun decodeWMO(weatherCode: Int): WeatherCondition {
    return when (weatherCode) {
        1, 2, 3 -> return WeatherCondition.CLOUDY
        in 40..50 -> return WeatherCondition.FOG
        in 59..69 -> return WeatherCondition.RAIN
        in 70..79 -> return WeatherCondition.SNOW
        in 94..99 -> return WeatherCondition.HEAVYRAIN
        else -> WeatherCondition.SUNNY
    }
}

fun getDayItaVersion(day : String) : String{
    return when(day){
        "MONDAY" -> "Lunedì"
        "TUESDAY" -> "Martedì"
        "WEDNESDAY" -> "Mercoledì"
        "THURSDAY" -> "Giovedì"
        "FRIDAY" -> "Venerdì"
        "SATURDAY" -> "Sabato"
        "SUNDAY" -> "Domenica"
        else -> ""
    }
}

fun getMonthItaVersion(month : String) : String {
    return when(month){
        "APRIL" -> "Aprile"
        else -> ""
    }
}
