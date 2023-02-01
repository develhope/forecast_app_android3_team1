package co.develhope.meteoapp.model_specyficDay

import co.develhope.meteoapp.data_specyficDay.DataClassForecast

sealed class SealedClassSpecyfDay {
    abstract val viewType: Int

    //--- titolo per palermo, data, ora etc ---
    data class DetailsTitle(
        val titleForecast: DataClassForecast.TitleForecast
    ) : SealedClassSpecyfDay() {
        override val viewType: Int = 0
    }

    //--- per la row con l'orario e le info generiche ---
    data class DetailsRow(
        val rowForecast: DataClassForecast.RowForecast

    ) : SealedClassSpecyfDay() {
        override val viewType: Int = 1
    }

    //--- per la card con le info dettagliate
    data class DetailsCard(
        val cardForecast: DataClassForecast.CardForecast
    ) : SealedClassSpecyfDay() {
        override val viewType: Int = 2
    }
}