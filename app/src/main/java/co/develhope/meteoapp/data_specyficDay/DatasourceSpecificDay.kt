package co.develhope.meteoapp.data_specyficDay

import co.develhope.meteoapp.R
import co.develhope.meteoapp.model_specyficDay.SealedClassSpecyfDay
import java.util.*

 sealed class  Bho {
     data class TitleForecast(
         val titleGiorno: Day,
         val titleData: Date
     )

     enum class Day {
         TODAY, TOMORROW
     }

     data class RowForecast(
         val time: Date,
         val weatherCondition: WeatherCondition,
         val humidity: Int,
         val temp: Int
     )

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
     )
 }

object DatasourceSpecificDay {

    fun loadData(): List<SealedClassSpecyfDay> {
        return listOf<SealedClassSpecyfDay> {
            Bho.TitleForecast(
                titleGiorno = Bho.Day.TODAY,
                titleData = Date()
            )
            Bho.RowForecast(
                time = Date(),
                weatherCondition = Bho.WeatherCondition,
                humidity = 0,
                temp = 31
            )
            Bho.CardForecast(
                percepita = 45,
                humidity = 60,
                copertura = 24,
                uv = 5,
                vento = 7,
                pioggia = 0
            )
        }
    }

}