package co.develhope.meteoapp.data

import android.content.Context
import android.content.SharedPreferences
import co.develhope.meteoapp.data.domainmodel.Place
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ApplicationPreferences(context : Context) {

    private val appPreferences = "meteoappsp"
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(appPreferences, Context.MODE_PRIVATE)
    private val PLACE = "place"
    private val PLACES = "places"
    private val gson = Gson()

    fun savePlace(place: Place) {
        return with(sharedPreferences.edit()) {
            val placeJson = gson.toJson(place)
            putString(PLACE, placeJson)
            apply()
        }
    }

    fun getCurrentPlace(): Place? {
        val currentPlace = sharedPreferences.getString(PLACE, null)
       return gson.fromJson(currentPlace, Place::class.java)
   }

    //--------------------
    fun loadRecentSearch() : List<Place> {
        val currentPlace = sharedPreferences.getString(PLACES, null)

        return currentPlace?.let {
            val itemType = object : TypeToken<List<Place>>() {}.type
            gson.fromJson(it, itemType)
        }?: emptyList()
    }

    fun saveRecentSearch(places :  List<Place>){
        return with(sharedPreferences.edit()){

            val placeJson = gson.toJson(places)
            putString(PLACES, placeJson)
            apply()
        }
    }

}