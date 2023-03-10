package co.develhope.meteoapp.ui.adapter.searchscreen

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R

class SearchTermViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val searchTerm = view.findViewById<TextView>(R.id.citynametextview)
    private val region = view.findViewById<TextView>(R.id.regiontextview)
    private val searchButton = view.findViewById<ConstraintLayout>(R.id.searchlayout)
    fun bind(city : SearchScreenItems.RecentSearch, listener : OnSelectPlace){
        searchTerm.text = city.city.city
        region.text = city.city.region
        searchButton.setOnClickListener {
            listener.selectPlace(city.city)
        }
    }
}