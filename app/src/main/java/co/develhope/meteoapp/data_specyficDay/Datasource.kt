package co.develhope.meteoapp.data_specyficDay

import co.develhope.meteoapp.R
import co.develhope.meteoapp.model_specyficDay.DetailsDay

class Datasource {
    fun loadDetailsDay(): List<DetailsDay> {  //creare List?
       return listOf<DetailsDay>(
           DetailsDay(R.string.ora_giorno,R.drawable.ic_icon_weather_provvisoria,R.string.temperatura_giorno,R.drawable.ic_icon_umidity_provvisoria,R.string.humidity),
           DetailsDay(R.string.ora_giorno,R.drawable.ic_icon_weather_provvisoria,R.string.temperatura_giorno,R.drawable.ic_icon_umidity_provvisoria,R.string.humidity),
           DetailsDay(R.string.ora_giorno,R.drawable.ic_icon_weather_provvisoria,R.string.temperatura_giorno,R.drawable.ic_icon_umidity_provvisoria,R.string.humidity),
           DetailsDay(R.string.ora_giorno,R.drawable.ic_icon_weather_provvisoria,R.string.temperatura_giorno,R.drawable.ic_icon_umidity_provvisoria,R.string.humidity)
       )


    }
}