package co.develhope.meteoapp.adapter_specyficDay

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data_specyficDay.WeatherCondition
import co.develhope.meteoapp.model_specyficDay.SpecyfDayScreenItem

//--- row ---
class RowViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val textViewRow: TextView = view.findViewById(R.id.today_hour_textview)
    private val imageViewRow: ImageView = view.findViewById(R.id.icon_weather_imageview)
    private val textViewRow2: TextView = view.findViewById(R.id.temperature_textview)
    private val textViewRow3: TextView = view.findViewById(R.id.humidity_textview)

    fun bind(detailsRow: SpecyfDayScreenItem.DetailsRow) {
        textViewRow.text = detailsRow.rowForecast.row.time.toString()
        when (detailsRow.rowForecast.row.weatherCondition) {
            WeatherCondition.SUNNY -> imageViewRow.setImageResource(R.drawable.ic_icon_sun)
            WeatherCondition.RAIN -> imageViewRow.setImageResource(R.drawable.ic_icon_rain)
            WeatherCondition.CLOUDY -> imageViewRow.setImageResource(R.drawable.ic_icon_cloudy)
        }
        textViewRow2.text = itemView.context.getString(R.string.simbol_gradi, detailsRow.rowForecast.row.temp.toString())
        textViewRow3.text = itemView.context.getString(R.string.simbol_percentuale, detailsRow.rowForecast.row.humidity.toString())
    }
}
