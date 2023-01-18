package co.develhope.meteoapp.data_specyficDay

import co.develhope.meteoapp.R
import co.develhope.meteoapp.model_specyficDay.DetailsDay

class Datasource {
    fun loadDetailsDay(): List<DetailsDay> {  //creare List?
       return listOf<DetailsDay>(
           DetailsDay(R.string.ora_giorno_12,R.drawable.ic_icon_sun,R.string.temperatura_giorno_20,R.drawable.ic_icon_humidity,R.string.humidity_10),
           DetailsDay(R.string.ora_giorno_13,R.drawable.ic_icon_rain,R.string.temperatura_giorno_20,R.drawable.ic_icon_humidity,R.string.humidity_20),
           DetailsDay(R.string.ora_giorno_14,R.drawable.ic_icon_cloudy,R.string.temperatura_giorno_25,R.drawable.ic_icon_humidity,R.string.humidity_30),
           DetailsDay(R.string.ora_giorno_12,R.drawable.ic_icon_sun,R.string.temperatura_giorno_30,R.drawable.ic_icon_humidity,R.string.humidity_10)
       )


    }
}