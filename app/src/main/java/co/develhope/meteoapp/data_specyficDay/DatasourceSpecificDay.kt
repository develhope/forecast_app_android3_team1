package co.develhope.meteoapp.data_specyficDay

import co.develhope.meteoapp.model_specyficDay.SealedClassSpecyfDay
import java.util.*

 sealed class  DataClassForecast {

     data class TitleForecast(
         val titleGiorno: Day,
         val titleData: Date
     ): DataClassForecast()

     enum class Day {
         TODAY, TOMORROW
     }

     data class RowForecast(
         val time: Date,
         val weatherCondition: WeatherCondition,
         val humidity: Int,
         val temp: Int
     ): DataClassForecast()

     enum class WeatherCondition {
         SUNNY, CLOUDY, RAIN
     }


     data class CardForecast(
         val percepita: Int,
         val humidity: Int,
         val copertura: Int,
         val uv: Int,
         val vento: Int,
         val pioggia: Int
     ): DataClassForecast()
 }


object DatasourceSpecificDay {

    fun loadData(): List<DataClassForecast> {
        return listOf(
            DataClassForecast.TitleForecast(
                titleGiorno = DataClassForecast.Day.TODAY,
                titleData = Date()
            ),
            DataClassForecast.RowForecast(
                time = Date(),
                weatherCondition = DataClassForecast.WeatherCondition.SUNNY,
                humidity = 0,
                temp = 31
        ),
            DataClassForecast.CardForecast(
                percepita = 45,
                humidity = 60,
                copertura = 24,
                uv = 5,
                vento = 7,
                pioggia = 0
        )
        )

    }
}



