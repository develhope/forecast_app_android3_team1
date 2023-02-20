package co.develhope.meteoapp.network.wheaterapi

import co.develhope.meteoapp.network.wheaterapi.dto.DailySummary
import co.develhope.meteoapp.network.wheaterapi.dto.WeeklySummary
import retrofit2.http.GET
import retrofit2.http.Query

interface WheaterService {

    //endpoint per dailysummary
    @GET("forecast?hourly=temperature_2m,rain,showers,snowfall,weathercode,windspeed_10m&current_weather=true&timezone=Europe%2FBerlin&start_date=2022-10-03&end_date=2022-10-03")
    suspend fun getDailyWehaterSummary(@Query("latitude") latitude : Double = 41.8955, @Query("longitude") longitude : Double = 12.4823) : DailySummary

    //endpoint per weeklysummary
    @GET("forecast?daily=weathercode,temperature_2m_max,temperature_2m_min,sunrise,sunset,precipitation_sum,rain_sum&current_weather=true&timezone=Europe%2FBerlin")
    suspend fun  getWeeklyWheaterSummary(@Query("latitude") latitude : Double = 41.8955, @Query("longitude") longitude : Double = 12.4823) : WeeklySummary

}