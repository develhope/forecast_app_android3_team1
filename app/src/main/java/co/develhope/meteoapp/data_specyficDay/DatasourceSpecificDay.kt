package co.develhope.meteoapp.data_specyficDay

import co.develhope.meteoapp.R
import co.develhope.meteoapp.model_specyficDay.SealedClassSpecyfDay

object DatasourceSpecificDay {
    fun loadSealedClass(): List<SealedClassSpecyfDay> {
       return listOf<SealedClassSpecyfDay>(
           SealedClassSpecyfDay.DetailsTitle(
               R.string.today,
               R.string.data_today
           ),
           SealedClassSpecyfDay.DetailsRow(
               R.string.ora_giorno_12,
               R.drawable.ic_icon_sun,
               R.string.temperatura_giorno_20,
               R.string.humidity_10
           ),
           SealedClassSpecyfDay.DetailsCard(
               R.string.percepita_40,
               R.string.UV_5_10,
               R.string.umidità_60,
               R.string.vento_7,
               R.string.copertura_24,
               R.string.pioggia_0cm
           ),
           SealedClassSpecyfDay.DetailsRow(
               R.string.ora_giorno_13,
               R.drawable.ic_icon_rain,
               R.string.temperatura_giorno_20,
               R.string.humidity_20
           ),
           SealedClassSpecyfDay.DetailsRow(
               R.string.ora_giorno_14,
               R.drawable.ic_icon_cloudy,
               R.string.temperatura_giorno_25,
               R.string.humidity_30
           ),
           SealedClassSpecyfDay.DetailsRow(
               R.string.ora_giorno_12,
               R.drawable.ic_icon_sun,
               R.string.temperatura_giorno_30,
               R.string.humidity_10
           ),
           SealedClassSpecyfDay.DetailsRow(
               R.string.ora_giorno_13,
               R.drawable.ic_icon_rain,
               R.string.temperatura_giorno_20,
               R.string.humidity_20
           ),
           SealedClassSpecyfDay.DetailsRow(
               R.string.ora_giorno_14,
               R.drawable.ic_icon_cloudy,
               R.string.temperatura_giorno_25,
               R.string.humidity_30
           ),
           SealedClassSpecyfDay.DetailsRow(
               R.string.ora_giorno_12,
               R.drawable.ic_icon_sun,
               R.string.temperatura_giorno_30,
               R.string.humidity_10
           )
       )

    }

}