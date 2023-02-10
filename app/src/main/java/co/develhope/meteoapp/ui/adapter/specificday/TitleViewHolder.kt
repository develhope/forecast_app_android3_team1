package co.develhope.meteoapp.ui.adapter.specificday

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R

class TitleViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    //--- title ---
    private val textViewTitle: TextView = view.findViewById(R.id.title_giorno)
    private val textViewTitle2: TextView = view.findViewById(R.id.title_data)
    private val textViewTitle3: TextView = view.findViewById(R.id.title_place)

    fun bind(detailsTitle: SpecyfDayScreenItem.DetailsTitle) {
        textViewTitle.text = detailsTitle.titleForecast.titleGiorno
        textViewTitle2.text = detailsTitle.titleForecast.titleData.toString()
        textViewTitle3.text = itemView.context.getString(R.string.simbol_virgola, detailsTitle.titleForecast.city,detailsTitle.titleForecast.region)

    }

}
