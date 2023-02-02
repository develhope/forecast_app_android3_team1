package co.develhope.meteoapp.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.adapter.HomeScreenItem.*

class TitleViewHolder (private val view: View) : RecyclerView.ViewHolder(view){
    private val textViewTitle : TextView = view.findViewById(R.id.textTitleHomeScreen)

    fun bind(title: TitleDetail){
        textViewTitle.text = title.titleHomeScreen.city.toString()
        textViewTitle.text = title.titleHomeScreen.region.toString()
    }

}