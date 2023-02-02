package co.develhope.meteoapp.data

import java.util.Date


enum class WeatherCondition {
    SUNNY, FOG, RAIN
}

data class DailyForecastSummary(
    val place: Place,
    val date: Date,
    val forecast: Forecast
)

data class Place(
    val city: String,
    val region: String,
    val lat: Double,
    val log: Double
)

data class Forecast(
    val minTemp: Int,
    val maxTemp: Int,
    val rainfall: Int,
    val wind: Int,
    val weatherCondition: WeatherCondition
)


object Datasource {

    fun loadData(): List<DailyForecastSummary> {
        return listOf<DailyForecastSummary>(
            DailyForecastSummary(
                place = Place(city = "Palermo", region = "Sicilia", lat = 0.0, log = 0.0),
                date = Date(),
                forecast = Forecast(
                    minTemp = 1,
                    maxTemp = 13,
                    rainfall = 5,
                    wind = 4,
                    weatherCondition = WeatherCondition.SUNNY
                )
            ),
            DailyForecastSummary(
                place = Place(city = "Palermo", region = "Sicilia", lat = 0.0, log = 0.0),
                date = Date(),
                forecast = Forecast(
                    minTemp = 1,
                    maxTemp = 13,
                    rainfall = 5,
                    wind = 4,
                    weatherCondition = WeatherCondition.SUNNY
                )
            ),
            DailyForecastSummary(
                place = Place(city = "Palermo", region = "Sicilia", lat = 0.0, log = 0.0),
                date = Date(),
                forecast = Forecast(
                    minTemp = 1,
                    maxTemp = 13,
                    rainfall = 5,
                    wind = 4,
                    weatherCondition = WeatherCondition.SUNNY
                )
            ),
            DailyForecastSummary(
                place = Place(city = "Palermo", region = "Sicilia", lat = 0.0, log = 0.0),
                date = Date(),
                forecast = Forecast(
                    minTemp = 1,
                    maxTemp = 13,
                    rainfall = 5,
                    wind = 4,
                    weatherCondition = WeatherCondition.SUNNY
                )
            ),
            DailyForecastSummary(
                place = Place(city = "Palermo", region = "Sicilia", lat = 0.0, log = 0.0),
                date = Date(),
                forecast = Forecast(
                    minTemp = 1,
                    maxTemp = 13,
                    rainfall = 5,
                    wind = 4,
                    weatherCondition = WeatherCondition.SUNNY
                )
            )


        )
    }
}