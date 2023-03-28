package co.develhope.meteoapp.ui.adapter.specificday

import co.develhope.meteoapp.data.domainmodel.CardForecast
import co.develhope.meteoapp.data.domainmodel.SpecyficDayForecastSummary
import co.develhope.meteoapp.data.domainmodel.TitleForecast


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
}