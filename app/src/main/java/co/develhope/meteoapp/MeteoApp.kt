package co.develhope.meteoapp

import android.app.Application
import co.develhope.meteoapp.data.ApplicationPreferences
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MeteoApp : Application() {


    companion object  {
        var preferences : ApplicationPreferences? = null
        lateinit var instance : MeteoApp
    }

    override fun onCreate() {
        super.onCreate()
        preferences = ApplicationPreferences(applicationContext)
        instance = this
    }
}