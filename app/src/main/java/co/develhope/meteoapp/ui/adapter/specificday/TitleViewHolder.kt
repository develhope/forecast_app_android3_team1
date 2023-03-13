package co.develhope.meteoapp.ui.adapter.specificday

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R

class TitleViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    //--- title ---
    private val dayTitle: TextView = view.findViewById(R.id.title_giorno)
    private val dataTitle: TextView = view.findViewById(R.id.title_data)
    private val placeTitle: TextView = view.findViewById(R.id.title_place)

    fun bind(detailsTitle: SpecyfDayScreenItem.DetailsTitle) {
        placeTitle.text =  "${detailsTitle.titleForecast.place.city},${detailsTitle.titleForecast.place.region}"
        dataTitle.text = itemView.context.getString(R.string.data_today, detailsTitle.titleForecast.date.dayOfWeek.name, detailsTitle.titleForecast.date.dayOfMonth.toString(),detailsTitle.titleForecast.date.month.name)
        dayTitle.text = "Oggi,"

    }

}
