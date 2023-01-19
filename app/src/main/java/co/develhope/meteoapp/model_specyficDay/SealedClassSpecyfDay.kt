package co.develhope.meteoapp.model_specyficDay

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class SealedClassSpecyfDay {




//--- titolo per palermo, data, ora etc ---
    data class DetailsTitle (
        @StringRes val titleGiorno: Int,
        @StringRes val titleData: Int
    ): SealedClassSpecyfDay(){


    }

//--- per la row con l'orario e le info generiche ---
    data class DetailsRow(
        @StringRes val todayHour: Int,
        @DrawableRes val iconWeather: Int,
        @StringRes val temperature: Int,
        @StringRes val humidity: Int
    ): SealedClassSpecyfDay(){

    }

//--- per la card con le info dettagliate
    data class DetailsCard (
        @StringRes val datoValPercep: Int,
        @StringRes val datoValUV: Int,
        @StringRes val datoValUmidità: Int,
        @StringRes val datoValVento: Int,
        @StringRes val datoValCopertura: Int,
        @StringRes val datoValPioggia: Int
    ): SealedClassSpecyfDay() {

    }

}