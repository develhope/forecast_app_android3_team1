package co.develhope.meteoapp.ui.adapter.searchscreen

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R

class SearchTermViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val searchTerm = view.findViewById<TextView>(R.id.citynametextview)

    fun bind(city : SearchScreenItems.RecentSearch){
        searchTerm.text = city.city.city
    }
}