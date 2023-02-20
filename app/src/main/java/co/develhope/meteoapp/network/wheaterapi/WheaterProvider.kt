package co.develhope.meteoapp.network.wheaterapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.open-meteo.com/v1/"

class WheaterProvider {
    val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    fun provideWheaterService() : WheaterService {
        return retrofit.create(WheaterService::class.java)
    }
}