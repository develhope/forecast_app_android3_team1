package co.develhope.meteoapp.data.domainmodel

import org.threeten.bp.OffsetDateTime

data class TitleForecast(
    val place: Place,
    val date: OffsetDateTime
)