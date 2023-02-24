package co.develhope.meteoapp.network.dto


import co.develhope.meteoapp.data.domainmodel.Place
import com.google.gson.annotations.SerializedName

data class CityInfo(
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double,
    @SerializedName("results")
    val results: List<Result>
){
    fun toDomain() : List<Place> {
        return this.results.map {
            Place(
                it.name,
                it?.admin1 ?: "null",
                it.latitude,
                it.longitude
            )
        }

    }
}