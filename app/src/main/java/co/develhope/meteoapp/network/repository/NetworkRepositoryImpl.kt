package co.develhope.meteoapp.network.repository

import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.network.GeoResponse
import co.develhope.meteoapp.network.HomeWeatherResponse
import co.develhope.meteoapp.network.dto.HomeSummary
import co.develhope.meteoapp.network.dto.SpecificSummary
import org.threeten.bp.OffsetDateTime
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val  provider : NetworkProvider
) : NetworkRepository {

    override suspend fun getDailySummary(place: Place): HomeWeatherResponse {
       return provider.getDailySummary(place)
    }

    override suspend fun getSpecificSummary(
        latitude: Double,
        longitude: Double,
        startDate: OffsetDateTime,
        endDate: OffsetDateTime
    ): SpecificSummary {
        return provider.getSpecificSummary(
            latitude,
            longitude,
            startDate,
            endDate
        )
    }

    override suspend fun getCityInfo(location: String, language: String): GeoResponse {
        return provider.getCityInfo(location, language)
    }
}