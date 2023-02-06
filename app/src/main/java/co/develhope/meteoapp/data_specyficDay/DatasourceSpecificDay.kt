package co.develhope.meteoapp.data_specyficDay

import java.util.*

     enum class WeatherCondition {
         SUNNY, CLOUDY, RAIN
     }

//--- data ---
data class  SpecyficDayForecastSummary(
    val title: TitleForecast,
    val row: RowForecast,
    val card: CardForecast
)

     data class TitleForecast(
         val city: String,
         val region: String,
         val lat: Double,
         val long: Double,
         val titleGiorno: String,
         val titleData: Date
     )

     data class RowForecast(
         val time: Int,
         val weatherCondition: WeatherCondition,
         val humidity: Int,
         val temp: Int
     )

     data class CardForecast(
         val percepita: Int,
         val humidity: Int,
         val copertura: Int,
         val uv: Int,
         val vento: Int,
         val pioggia: Int
     )


object DatasourceSpecificDay {

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



