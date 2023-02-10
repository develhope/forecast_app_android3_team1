package co.develhope.meteoapp.data

import co.develhope.meteoapp.data.domainmodel.DailyForecastSummary
import co.develhope.meteoapp.data.domainmodel.Forecast
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.data.domainmodel.WeatherCondition


object Datasource {

    fun loadData(): List<DailyForecastSummary> {
        return listOf<DailyForecastSummary>(
            DailyForecastSummary(
                place = Place(city = "Palermo", region = "Sicilia", lat = 0.0, log = 0.0),
                date = "03/02",
                forecast = Forecast(
                    minTemp = 22,
                    maxTemp = 31,
                    rainfall = 0,
                    wind = 12,
                    weatherCondition = WeatherCondition.SUNNY
                )
            ),
            DailyForecastSummary(
                place = Place(city = "Palermo", region = "Sicilia", lat = 0.0, log = 0.0),
                date = "04/02",
                forecast = Forecast(
                    minTemp = 18,
                    maxTemp = 22,
                    rainfall = 15,
                    wind = 28,
                    weatherCondition = WeatherCondition.FOG
                )
            ),
            DailyForecastSummary(
                place = Place(city = "Palermo", region = "Sicilia", lat = 0.0, log = 0.0),
                date = "05/02",
                forecast = Forecast(
                    minTemp = 22,
                    maxTemp = 31,
                    rainfall = 0,
                    wind = 12,
                    weatherCondition = WeatherCondition.SUNNY
                )
            ),
            DailyForecastSummary(
                place = Place(city = "Palermo", region = "Sicilia", lat = 0.0, log = 0.0),
                date = "06/02",
                forecast = Forecast(
                    minTemp = 20,
                    maxTemp = 25,
                    rainfall = 90,
                    wind = 32,
                    weatherCondition = WeatherCondition.RAIN
                )
            ),
            DailyForecastSummary(
                place = Place(city = "Palermo", region = "Sicilia", lat = 0.0, log = 0.0),
                date = "07/02",
                forecast = Forecast(
                    minTemp = 24,
                    maxTemp = 30,
                    rainfall = 9,
                    wind = 13,
                    weatherCondition = WeatherCondition.FOG
                )
            )


        )
    }
}