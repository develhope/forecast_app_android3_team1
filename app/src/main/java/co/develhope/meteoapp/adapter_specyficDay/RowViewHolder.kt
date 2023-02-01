package co.develhope.meteoapp.adapter_specyficDay

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data_specyficDay.DataClassForecast
import co.develhope.meteoapp.model_specyficDay.SealedClassSpecyfDay

//--- row ---
class RowViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val textViewRow: TextView = view.findViewById(R.id.today_hour_textview)
    private val imageViewRow: ImageView? = null
    private val textViewRow2: TextView = view.findViewById(R.id.temperature_textview)
    private val textViewRow3: TextView = view.findViewById(R.id.humidity_textview)

    fun bind(detailsRow: SealedClassSpecyfDay.DetailsRow) {
        textViewRow.text = detailsRow.rowForecast.time.toString()
        when (detailsRow.rowForecast.weatherCondition) {
            DataClassForecast.WeatherCondition.SUNNY -> imageViewRow?.setImageResource(R.drawable.ic_icon_sun)
            DataClassForecast.WeatherCondition.RAIN -> imageViewRow?.setImageResource(R.drawable.ic_icon_rain)
            DataClassForecast.WeatherCondition.CLOUDY -> imageViewRow?.setImageResource(R.drawable.ic_icon_cloudy)
        }
        textViewRow2.text = detailsRow.rowForecast.temp.toString()
        textViewRow3.text = detailsRow.rowForecast.humidity.toString()
    }
}
