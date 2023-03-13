package co.develhope.meteoapp.data.domainmodel

data class CardForecast(
    val percepita: Double,
    val humidity: Int,
    val copertura: Int,
    val uv: Int?,
    val vento: Int,
    val pioggia: Int
)