package co.develhope.meteoapp.model_specyficDay

import co.develhope.meteoapp.data_specyficDay.CardForecast
import co.develhope.meteoapp.data_specyficDay.SpecyficDayForecastSummary
import co.develhope.meteoapp.data_specyficDay.TitleForecast


sealed class SpecyfDayScreenItem {
    abstract val viewType: Int

    //--- titolo per palermo, data, ora etc ---
    data class DetailsTitle(
        val titleForecast: TitleForecast,
    ) : SpecyfDayScreenItem() {
        override val viewType: Int = 0
    }

    //--- per la row con l'orario e le info generiche ---
    data class DetailsRow(
        val rowForecast: SpecyficDayForecastSummary,
        ) : SpecyfDayScreenItem() {
        override val viewType: Int = 1
    }

    //--- per la card con le info dettagliate
    data class DetailsCard(
        val cardForecast: CardForecast,
    ) : SpecyfDayScreenItem() {
        override val viewType: Int = 2
    }
}