package co.develhope.meteoapp.network.service

import co.develhope.meteoapp.network.dto.HomeSummary
import co.develhope.meteoapp.network.dto.SpecificSummary
import org.threeten.bp.LocalDate
import retrofit2.http.GET
import retrofit2.http.Query

interface WheaterService {

    //endpoint per dailysummary
    @GET("forecast?daily=weathercode,temperature_2m_max,windspeed_10m_max,temperature_2m_min,sunrise,sunset,precipitation_sum,rain_sum&current_weather=true&timezone=Europe%2FBerlin")
    suspend fun getDailyWehaterSummary(
        @Query("latitude") latitude : Double ,
        @Query("longitude") longitude : Double,
    ) : HomeSummary

    //endpoint per weeklysummary
    @GET("forecast?hourly=temperature_2m,rain,showers,snowfall,weathercode,windspeed_10m&current_weather=true&timezone=Europe%2FBerlin")
    suspend fun  getSpecificDaySummary(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("start_date") startDate: LocalDate,
        @Query("end_date") endDate: LocalDate
    ) : SpecificSummary

}