package co.develhope.meteoapp.ui.adapter.specificday

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.ui.utils.decodeWeatherIcon
import org.threeten.bp.format.DateTimeFormatter

//--- row ---
class RowViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val timeRow: TextView = view.findViewById(R.id.today_time_textview)
    private val weatherRow: ImageView = view.findViewById(R.id.icon_weather_imageview)
    private val temperatureRow: TextView = view.findViewById(R.id.temperature_textview)
    private val humidityRow: TextView = view.findViewById(R.id.humidity_textview)

    private val percepitaCard: TextView = view.findViewById(R.id.val_percep)
    private val umiditàCard: TextView = view.findViewById(R.id.val_umidità)
    private val coperturaCard: TextView = view.findViewById(R.id.val_copertura)
    private val uvCard: TextView = view.findViewById(R.id.val_UV)
    private val ventoCard: TextView = view.findViewById(R.id.val_vento)
    private val pioggiaCard: TextView = view.findViewById(R.id.val_pioggia)

    fun bind(detailsRow: SpecyfDayScreenItem.DetailsRow) {
        timeRow.text = itemView.context.getString(
            R.string.ora_giorno, detailsRow.rowForecast.row.time.format(
                DateTimeFormatter.ofPattern("HH:mm")
            )
        )
        weatherRow.setImageResource(decodeWeatherIcon(detailsRow.rowForecast.row.weatherCondition))
        temperatureRow.text = itemView.context.getString(
            R.string.simbol_gradi,
            detailsRow.rowForecast.row.temp.toString()
        )
        humidityRow.text = itemView.context.getString(
            R.string.simbol_percentuale,
            detailsRow.rowForecast.row.humidity.toString()
        )

        percepitaCard.text = itemView.context.getString(
            R.string.simbol_gradi,
            detailsRow.rowForecast.card.percepita.toString()
        )
        umiditàCard.text = itemView.context.getString(
            R.string.simbol_percentuale,
            detailsRow.rowForecast.card.humidity.toString()
        )
        coperturaCard.text = itemView.context.getString(
            R.string.simbol_percentuale,
            detailsRow.rowForecast.card.copertura.toString()
        )
        uvCard.text = itemView.context.getString(
            R.string.simbol_UV,
            detailsRow.rowForecast.card.uv.toString()
        )
        ventoCard.text = itemView.context.getString(
            R.string.simbol_SSE,
            detailsRow.rowForecast.card.vento.toString()
        )
        pioggiaCard.text = itemView.context.getString(
            R.string.simbol_cm,
            detailsRow.rowForecast.card.pioggia.toString()
        )
    }
}
