package co.develhope.meteoapp.data.domainmodel

data class CardForecast(
    val percepita: Double,
    val humidity: Double,
    val copertura: Double,
    val uv: Double,
    val vento: Double,
    val pioggia: Int
)