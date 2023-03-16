package co.develhope.meteoapp.ui.adapter.specificday

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.domainmodel.WeatherCondition
import co.develhope.meteoapp.ui.utils.decodeWMO
import co.develhope.meteoapp.ui.utils.decodeWeatherIcon
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.temporal.ChronoUnit

//--- row ---
class RowViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val timeRow: TextView = view.findViewById(R.id.today_time_textview)
    private val weatherRow: ImageView = view.findViewById(R.id.icon_weather_imageview)
    private val temperatureRow: TextView = view.findViewById(R.id.temperature_textview)
    private val humidityRow: TextView = view.findViewById(R.id.humidity_textview)

    fun bind(detailsRow: SpecyfDayScreenItem.DetailsRow) {
        timeRow.text = itemView.context.getString(R.string.ora_giorno, detailsRow.rowForecast.row.time.format(
            DateTimeFormatter.ofPattern("HH:mm")))
        weatherRow.setImageResource(decodeWeatherIcon(detailsRow.rowForecast.row.weatherCondition))
        temperatureRow.text = itemView.context.getString(R.string.simbol_gradi, detailsRow.rowForecast.row.temp.toString())
        humidityRow.text = itemView.context.getString(R.string.simbol_percentuale, detailsRow.rowForecast.row.humidity.toString())
    }
}
