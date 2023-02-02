package co.develhope.meteoapp.data

import co.develhope.meteoapp.adapter.HomeScreenItem

sealed class Data {

    data class HomeScreenTitle(
        val city: String,
        val region: String
    ) : Data()

    data class HourlyForecast(
        val date: Int,
        val minTemp: Int,
        val maxTemp: Int,
        val rainfall: Int,
        val wind: Int,
        val weatherCondition: WeatherCondition
    ) : Data()

    enum class WeatherCondition {
        SUNNY, FOG, RAIN
    }

    data class NextDays(
        val nextDays: String
    ) : Data()

    object DatasourceHomeScreen : Data(){


        fun loadData(): List<Data> {
            return listOf <Data> (
                HomeScreenTitle(
                    city = "Palermo",
                    region = "Sicilia"
                ),

                HourlyForecast(
                    date = 11,
                    minTemp = 18,
                    maxTemp = 31,
                    rainfall = 0,
                    wind = 12,
                    weatherCondition = WeatherCondition.RAIN
                ),

                NextDays(
                    nextDays = "Prossimi 5 Giorni"
                )

            )
        }
    }
}