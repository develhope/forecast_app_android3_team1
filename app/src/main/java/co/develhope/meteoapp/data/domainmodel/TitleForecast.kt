package co.develhope.meteoapp.data.domainmodel

import org.threeten.bp.OffsetDateTime
import java.util.Date

data class TitleForecast(
    val city: String,
    val region: String,
    val lat: Double,
    val long: Double,
    val titleGiorno: String,
    val titleData: OffsetDateTime
)