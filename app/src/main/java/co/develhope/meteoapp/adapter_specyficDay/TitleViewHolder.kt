package co.develhope.meteoapp.adapter_specyficDay

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.model_specyficDay.SealedClassSpecyfDay

class TitleViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    //--- title ---
    private val textViewTitle: TextView = view.findViewById(R.id.title_giorno)
    private val textViewTitle2: TextView = view.findViewById(R.id.title_data)

    fun bind(detailsTitle: SealedClassSpecyfDay.DetailsTitle) {
        textViewTitle.text = detailsTitle.titleForecast.titleGiorno.toString()
        textViewTitle2.text = detailsTitle.titleForecast.titleData.toString()

    }

}
