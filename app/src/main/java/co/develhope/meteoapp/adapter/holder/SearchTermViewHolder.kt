package co.develhope.meteoapp.adapter.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.model.RecyclerViewData

class SearchTermViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val searchTerm = view.findViewById<TextView>(R.id.citynametextview)

    fun bind(city : RecyclerViewData.RecentSearch){
        searchTerm.text = city.cityName
    }
}