package co.develhope.meteoapp.data

import android.content.Context
import android.content.SharedPreferences
import co.develhope.meteoapp.data.domainmodel.Place
import com.google.gson.Gson

class ApplicationPreferences(context : Context) {

    private val appPreferences = "currentplace"
    private val sharedPreferences : SharedPreferences = context.
    getSharedPreferences(appPreferences,Context.MODE_PRIVATE)

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

    fun loadRecentSearch() : List<Place> {
        val currentPlace = sharedPreferences.getString("places", null)
        val json = Gson()
        return json.fromJson(currentPlace, List<Place>::class.java)
    }

    fun saveRecentSearch(places :  List<Place>){
        return with(sharedPreferences.edit()){
            val json = Gson()
            val placeJson = json.toJson(places)
            putString("places",placeJson)
            apply()
        }
    }

}