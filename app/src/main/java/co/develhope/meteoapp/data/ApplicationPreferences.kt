package co.develhope.meteoapp.data

import android.content.Context
import android.content.SharedPreferences
import co.develhope.meteoapp.data.domainmodel.Place
import com.google.gson.Gson

class ApplicationPreferences(context : Context) {

    private val appPreferences = "currentplace"
    private val sharedPreferences : SharedPreferences = context.getSharedPreferences(appPreferences,Context.MODE_PRIVATE)

    fun savePlace(place : Place) {
        return with(sharedPreferences.edit()){
            val json = Gson()
            val placeJson = json.toJson(place)
            putString("place",placeJson)
            apply()
        }
    }

   fun getCurrentPlace() : Place? {
       val currentPlace = sharedPreferences.getString("place", null)
       val json = Gson()
       return json.fromJson(currentPlace, Place::class.java)
   }



}