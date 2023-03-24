package co.develhope.meteoapp.data

import co.develhope.meteoapp.MeteoApp
import co.develhope.meteoapp.data.domainmodel.Place
import org.threeten.bp.OffsetDateTime


object Datasource {

    fun getSelectedDate() = OffsetDateTime.now()
    fun getTime(): OffsetDateTime = OffsetDateTime.now()

}