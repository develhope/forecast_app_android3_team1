package co.develhope.meteoapp.data

import co.develhope.meteoapp.data.domainmodel.CardForecast
import co.develhope.meteoapp.data.domainmodel.DailyForecastSummary
import co.develhope.meteoapp.data.domainmodel.Forecast
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.data.domainmodel.RowForecast
import co.develhope.meteoapp.data.domainmodel.SpecyficDayForecastSummary
import co.develhope.meteoapp.data.domainmodel.TitleForecast
import co.develhope.meteoapp.data.domainmodel.WeatherCondition
import co.develhope.meteoapp.ui.adapter.searchscreen.SearchScreenItems
import java.util.Date


object Datasource {

    fun loadDataFromScreen(): List<DailyForecastSummary> {
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

    private val recentSearchList = mutableListOf(
        SearchScreenItems.RecentSearchTitle("Recent Search"),
        SearchScreenItems.RecentSearch("Palermo"),
        SearchScreenItems.RecentSearch("Catanzaro"),
        SearchScreenItems.RecentSearch("Roma"),
        SearchScreenItems.RecentSearch("Milano")
    )

    fun loadRecentSearch() : List<SearchScreenItems> {
        return recentSearchList
    }

    fun loadData(): List<SpecyficDayForecastSummary> {
        return listOf(
            SpecyficDayForecastSummary(
                title = TitleForecast(
                    city = "Torino",
                    region = "Piemonte",
                    lat = 2.3,
                    long = 4.4,
                    titleGiorno = "Oggi",
                    titleData = Date()
                ),
                row = RowForecast (
                    time = 10,
                    weatherCondition = WeatherCondition.SUNNY,
                    humidity = 20,
                    temp = 30
                ),
                card = CardForecast(
                    percepita = 45,
                    humidity = 60,
                    copertura = 24,
                    uv = 5,
                    vento = 7,
                    pioggia = 0
                )
            ),
            SpecyficDayForecastSummary(
                title = TitleForecast(
                    city = "Torino",
                    region = "Piemonte",
                    lat = 2.3,
                    long = 4.4,
                    titleGiorno = "Oggi",
                    titleData = Date()
                ),
                row = RowForecast (
                    time = 11,
                    weatherCondition = WeatherCondition.CLOUDY,
                    humidity = 10,
                    temp = 21
                ),
                card = CardForecast(
                    percepita = 4,
                    humidity = 60,
                    copertura = 24,
                    uv = 5,
                    vento = 7,
                    pioggia = 0
                )
            ),
            SpecyficDayForecastSummary(
                title = TitleForecast(
                    city = "Torino",
                    region = "Piemonte",
                    lat = 2.3,
                    long = 4.4,
                    titleGiorno = "Oggi",
                    titleData = Date()
                ),
                row = RowForecast (
                    time = 12,
                    weatherCondition = WeatherCondition.RAIN,
                    humidity = 55,
                    temp = 41
                ),
                card = CardForecast(
                    percepita = 5,
                    humidity = 60,
                    copertura = 24,
                    uv = 5,
                    vento = 7,
                    pioggia = 0
                )
            ),
            SpecyficDayForecastSummary(
                title = TitleForecast(
                    city = "Torino",
                    region = "Piemonte",
                    lat = 2.3,
                    long = 4.4,
                    titleGiorno = "Oggi",
                    titleData = Date()
                ),
                row = RowForecast (
                    time = 13,
                    weatherCondition = WeatherCondition.SUNNY,
                    humidity = 0,
                    temp = 31
                ),
                card = CardForecast(
                    percepita = 45,
                    humidity = 60,
                    copertura = 24,
                    uv = 5,
                    vento = 7,
                    pioggia = 10
                )
            ),
            SpecyficDayForecastSummary(
                title = TitleForecast(
                    city = "Torino",
                    region = "Piemonte",
                    lat = 2.3,
                    long = 4.4,
                    titleGiorno = "Oggi",
                    titleData = Date()
                ),
                row = RowForecast (
                    time = 14,
                    weatherCondition = WeatherCondition.SUNNY,
                    humidity = 0,
                    temp = 31
                ),
                card = CardForecast(
                    percepita = 45,
                    humidity = 60,
                    copertura = 24,
                    uv = 5,
                    vento = 7,
                    pioggia = 20
                )
            ),
            SpecyficDayForecastSummary(
                title = TitleForecast(
                    city = "Torino",
                    region = "Piemonte",
                    lat = 2.3,
                    long = 4.4,
                    titleGiorno = "Oggi",
                    titleData = Date()
                ),
                row = RowForecast (
                    time = 15,
                    weatherCondition = WeatherCondition.SUNNY,
                    humidity = 0,
                    temp = 31
                ),
                card = CardForecast(
                    percepita = 45,
                    humidity = 60,
                    copertura = 24,
                    uv = 5,
                    vento = 7,
                    pioggia = 0
                )
            )

        )
    }
}