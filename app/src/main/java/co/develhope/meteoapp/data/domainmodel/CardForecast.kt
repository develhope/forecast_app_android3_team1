package co.develhope.meteoapp.data.domainmodel

data class CardForecast(
    val percepita: Int,
    val humidity: Int,
    val copertura: Int,
    val uv: Int?,
    val vento: Int,
    val pioggia: Int
)