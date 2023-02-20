package co.develhope.meteoapp.network.wheaterapi

import co.develhope.meteoapp.network.wheaterapi.dto.WheaterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WheaterService {

    @GET("forecast?&hourly=temperature_2m,relativehumidity_2m,apparent_temperature,precipitation,rain,weathercode,cloudcover,visibility,windspeed_10m&daily=weathercode,temperature_2m_max,temperature_2m_min,uv_index_max,precipitation_sum,windspeed_10m_max&timezone=auto")
    suspend fun getWheaterResponse(@Query("latitude") latitude : Double, @Query("longitude") longitude : Double) : WheaterResponse
}