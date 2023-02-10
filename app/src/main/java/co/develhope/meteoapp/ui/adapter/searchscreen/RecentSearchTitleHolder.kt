package co.develhope.meteoapp.ui.adapter.searchscreen

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.model.RecyclerViewData

class RecentSearchTitleHolder(view : View) : RecyclerView.ViewHolder(view){
    private val title = view.findViewById<TextView>(R.id.recent_search_title)

    fun bind(searchtitle : RecyclerViewData.RecentSearchTitle){
        title.text = searchtitle.title
    }
}