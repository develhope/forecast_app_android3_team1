package co.develhope.meteoapp.data

import co.develhope.meteoapp.data.domainmodel.DailyForecastSummary
import co.develhope.meteoapp.data.domainmodel.Forecast
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.data.domainmodel.WeatherCondition
import org.threeten.bp.OffsetDateTime


object Datasource {

    fun loadDataFromScreen(): List<DailyForecastSummary> {
        return listOf<DailyForecastSummary>(
            DailyForecastSummary(
                place = Place(city = "Palermo", region = "Sicilia", lat = 0.0, log = 0.0),
                date = OffsetDateTime.now(),
                forecast = Forecast(
                    minTemp = 22,
                    maxTemp = 31,
                    rainfall = 0,
                    wind = 12,
                    weatherCondition = WeatherCondition.SUNNY,
                    date = OffsetDateTime.now()
                )
            ),
            DailyForecastSummary(
                place = Place(city = "Palermo", region = "Sicilia", lat = 0.0, log = 0.0),
                date = OffsetDateTime.now().plusDays(1),
                forecast = Forecast(
                    minTemp = 18,
                    maxTemp = 22,
                    rainfall = 15,
                    wind = 28,
                    weatherCondition = WeatherCondition.FOG,
                    date = OffsetDateTime.now()
                )
            ),
            DailyForecastSummary(
                place = Place(city = "Palermo", region = "Sicilia", lat = 0.0, log = 0.0),
                date = OffsetDateTime.now().plusDays(2),
                forecast = Forecast(
                    minTemp = 22,
                    maxTemp = 31,
                    rainfall = 0,
                    wind = 12,
                    weatherCondition = WeatherCondition.SUNNY,
                    date = OffsetDateTime.now()
                )
            ),
            DailyForecastSummary(
                place = Place(city = "Palermo", region = "Sicilia", lat = 0.0, log = 0.0),
                date = OffsetDateTime.now().plusDays(3),
                forecast = Forecast(
                    minTemp = 20,
                    maxTemp = 25,
                    rainfall = 90,
                    wind = 32,
                    weatherCondition = WeatherCondition.RAIN,
                    date = OffsetDateTime.now()
                )
            ),
            DailyForecastSummary(
                place = Place(city = "Palermo", region = "Sicilia", lat = 0.0, log = 0.0),
                date = OffsetDateTime.now().plusDays(4),
                forecast = Forecast(
                    minTemp = 24,
                    maxTemp = 30,
                    rainfall = 9,
                    wind = 13,
                    weatherCondition = WeatherCondition.FOG,
                    date = OffsetDateTime.now()
                )
            ),
            DailyForecastSummary(
                place = Place(city = "Palermo", region = "Sicilia", lat = 0.0, log = 0.0),
                date = OffsetDateTime.now().plusDays(5),
                forecast = Forecast(
                    minTemp = 27,
                    maxTemp = 31,
                    rainfall = 0,
                    wind = 10,
                    weatherCondition = WeatherCondition.FOG,
                    date = OffsetDateTime.now()
                )
            )


        )
    }

    private val recentSearchList = mutableListOf(
        Place("Palermo","Sicily",0.0,0.0),
        Place("Catanzaro","Calabria",0.0,0.0),
        Place("Roma","Lazio",0.0,0.0),
        Place("Milano","Lombardia",0.0,0.0),
        Place("Napoli","Campania",0.0,0.0)
    )

    fun loadRecentSearch() : List<Place> {
        return recentSearchList
    }


    /* fun loadData(): List<SpecyficDayForecastSummary> {
         return mutableListOf(
             SpecyficDayForecastSummary(
                 title = TitleForecast(
                     city = "Torino",
                     region = "Piemonte",
                     lat = 2.3,
                     long = 4.4,
                     titleGiorno = "Oggi",
                     titleData = OffsetDateTime.now()
                 ),
                 row = RowForecast (
                     time = OffsetDateTime.now().hour.plus(1),
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
                     titleData = OffsetDateTime.now()
                 ),
                 row = RowForecast (
                     time = OffsetDateTime.now().hour.plus(2),
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
                     titleData = OffsetDateTime.now()
                 ),
                 row = RowForecast (
                     time = OffsetDateTime.now().hour.plus(3),
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
                     titleData = OffsetDateTime.now()
                 ),
                 row = RowForecast (
                     time = OffsetDateTime.now().hour.plus(4),
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
                     titleData = OffsetDateTime.now()
                 ),
                 row = RowForecast (
                     time = OffsetDateTime.now().hour.plus(5),
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
                     titleData = OffsetDateTime.now()
                 ),
                 row = RowForecast (
                     time = OffsetDateTime.now().hour.plus(6),
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
             ),
             SpecyficDayForecastSummary(
                 title = TitleForecast(
                     city = "Torino",
                     region = "Piemonte",
                     lat = 2.3,
                     long = 4.4,
                     titleGiorno = "Oggi",
                     titleData = OffsetDateTime.now()
                 ),
                 row = RowForecast (
                     time = OffsetDateTime.now().hour.plus(7),
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
     }*/
}