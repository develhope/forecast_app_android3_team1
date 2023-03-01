package co.develhope.meteoapp.network.service

import org.threeten.bp.OffsetDateTime
import retrofit2.http.GET
import retrofit2.http.Query

interface WheaterService {

    //endpoint per dailysummary
    @GET("forecast?daily=weathercode,temperature_2m_max,temperature_2m_min,sunrise,sunset,precipitation_sum,rain_sum&current_weather=true&timezone=Europe%2FBerlin")
    suspend fun getDailyWehaterSummary(
        @Query("latitude") latitude : Double = 41.8955,
        @Query("longitude") longitude : Double = 12.4823,
    )

    //endpoint per weeklysummary
    @GET("forecast?hourly=temperature_2m,rain,showers,snowfall,weathercode,windspeed_10m&current_weather=true&timezone=Europe%2FBerlin")
    suspend fun  getSpecificDaySummary(
        @Query("latitude") latitude : Double = 41.8955,
        @Query("longitude") longitude : Double = 12.4823,
        @Query("start_date") startDate : OffsetDateTime,
        @Query("end_date") endDate : OffsetDateTime)

}