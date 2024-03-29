package co.develhope.meteoapp.network

import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.network.dto.CityInfo
import co.develhope.meteoapp.network.dto.HomeSummary
import co.develhope.meteoapp.network.dto.SpecificSummary
import co.develhope.meteoapp.network.service.GeocodingService
import co.develhope.meteoapp.network.service.WheaterService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.threeten.bp.OffsetDateTime
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkProvider {

    private val BASE_URL = "https://api.open-meteo.com/v1/"
    private val BASE_URL_GEOCODING = "https://geocoding-api.open-meteo.com/v1/"


    private val retrofitWeather = provideWeatherRetrofit(
        client = provideOkHttpClient(provideHttpLoggingInterceptor()),
        gson = provideGson()
    )
    private val retrofitGeocoding = provideGeocodingRetrofit(
        client = provideOkHttpClient(provideHttpLoggingInterceptor()),
        gson = provideGson()
    )


    private fun provideWeatherRetrofit(
        client: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }


    private fun provideGeocodingRetrofit(
        client: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_GEOCODING)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    private fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }



    fun provideWeatherService() : WheaterService {
        return retrofitWeather.create(WheaterService::class.java)
    }

    fun provideGeocodingService() : GeocodingService {
        return retrofitGeocoding.create(GeocodingService::class.java)
    }

    private fun provideGson(): Gson = GsonBuilder()
        .registerTypeAdapter(OffsetDateTime::class.java, OffsetDateTimeTypeAdapter())
        .create()

    // mancano le funzioni che vanno usate per le chiamate di rete


    suspend fun getDailySummary(place : Place) : HomeSummary {
        val wheaterService = provideWeatherService()
        return wheaterService.getDailyWehaterSummary(place.lat,place.log)
    }

    suspend fun getSpecificSummary(latitude : Double, longitude : Double, startDate: OffsetDateTime, endDate: OffsetDateTime) : SpecificSummary{
        val wheaterService = provideWeatherService()
        return wheaterService.getSpecificDaySummary(
            latitude,
            longitude,
            startDate.toLocalDate(),
            endDate.toLocalDate()
        )
    }
}