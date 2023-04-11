package co.develhope.meteoapp.network.repository

import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.network.GeoResponse
import co.develhope.meteoapp.network.HomeWeatherResponse
import co.develhope.meteoapp.network.SpecificWeatherResponse
import co.develhope.meteoapp.network.dto.HomeSummary
import co.develhope.meteoapp.network.dto.SpecificSummary
import org.threeten.bp.OffsetDateTime

interface NetworkRepository {

    suspend fun getDailySummary(place : Place): HomeWeatherResponse

    suspend fun getSpecificSummary(
        latitude : Double,
        longitude : Double,
        startDate : OffsetDateTime,
        endDate : OffsetDateTime
    ) : SpecificWeatherResponse

    suspend fun getCityInfo(location : String, language : String) : GeoResponse

}