package co.develhope.meteoapp.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import co.develhope.meteoapp.network.dto.CityInfo
import co.develhope.meteoapp.network.dto.HomeSummary
import co.develhope.meteoapp.network.dto.SpecificSummary

fun isOnline(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val capabilities =
        connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    if (capabilities != null) {
        if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
            Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
            return true
        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
            Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
            return true
        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
            Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
            return true
        }
    }
    return false
}

sealed class GeoResponse {
    data class GeoSuccess(val response : CityInfo) : GeoResponse()
    data class GeoProblems(val exception: java.lang.Exception) : GeoResponse()
}

sealed class HomeWeatherResponse {
    data class HomeWeatherSuccess(val response : HomeSummary) : HomeWeatherResponse()
    data class HomeWeatherFail(val response : java.lang.Exception) : HomeWeatherResponse()
}

sealed class SpecificWeatherResponse {
    data class SpecificWeatherSuccess(val response : SpecificSummary) : SpecificWeatherResponse()
    data class SpecificWeatherFail(val exception : java.lang.Exception) : SpecificWeatherResponse()
}