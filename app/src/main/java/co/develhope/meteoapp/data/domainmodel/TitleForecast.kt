package co.develhope.meteoapp.data.domainmodel

import org.threeten.bp.OffsetDateTime
import java.util.Date

data class TitleForecast(
    val place: Place,
    val titleGiorno: String,
    val titleData: OffsetDateTime
)