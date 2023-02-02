package co.develhope.meteoapp.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.HomeScreenItems

class TitleViewHolder (private val view: View) : RecyclerView.ViewHolder(view){
    private val textViewTitle : TextView = view.findViewById(R.id.textTitleHomeScreen)

    fun bind(title: HomeScreenItems.HomeScreenTitle){
        //%s, %s
        //context.getString(pippo, title.place.city, title.place.region
        textViewTitle.text = title.place.city
        textViewTitle.text = title.place.region
    }

}