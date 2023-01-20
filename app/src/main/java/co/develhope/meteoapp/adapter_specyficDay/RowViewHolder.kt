package co.develhope.meteoapp.adapter_specyficDay

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.model_specyficDay.SealedClassSpecyfDay

//--- row ---
 class RowViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val textViewRow: TextView = view.findViewById(R.id.today_hour_textview)
        private val imageViewRow: ImageView = view.findViewById(R.id.icon_weather_imageview)
        private val textViewRow2: TextView = view.findViewById(R.id.temperature_textview)
        private val textViewRow3: TextView = view.findViewById(R.id.humidity_textview)

        fun bind(detailsRow: SealedClassSpecyfDay.DetailsRow) {
            textViewRow.text = view.context.resources.getString(detailsRow.todayHour)
            imageViewRow.setImageResource(detailsRow.iconWeather)
            textViewRow2.text = view.context.resources.getString(detailsRow.temperature)
            textViewRow3.text = view.context.resources.getString(detailsRow.humidity)
        }
    }