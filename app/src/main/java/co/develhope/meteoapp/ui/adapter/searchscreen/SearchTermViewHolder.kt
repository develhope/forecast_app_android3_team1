package co.develhope.meteoapp.ui.adapter.searchscreen

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Datasource
import co.develhope.meteoapp.data.domainmodel.Place

class SearchTermViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val searchTerm = view.findViewById<TextView>(R.id.citynametextview)
    private val region = view.findViewById<TextView>(R.id.regiontextview)
    private val searchButton = view.findViewById<ConstraintLayout>(R.id.searchlayout)

    fun bind(city : SearchScreenItems.RecentSearch, onItemClick : (Place) -> Unit){
        searchTerm.text = city.city.city
        region.text = city.city.region

        view.setOnClickListener{
            onItemClick(city.city)

        }

    }

}
