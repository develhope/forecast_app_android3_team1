package co.develhope.meteoapp.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.HomeScreenItems

class CardViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val textViewCardMinTemp: TextView = view.findViewById(R.id.minTempCard)
    private val textViewCardMaxTemp: TextView = view.findViewById(R.id.maxTempCard)
    private val textViewCardDate: TextView = view.findViewById(R.id.dateCard)
    private val textViewCardRainfall: TextView = view.findViewById(R.id.rainfallPercent)
    private val textViewCardWind: TextView = view.findViewById(R.id.windKmhCard)


    fun bind(cardDetail: HomeScreenItems.Forecast) {
        textViewCardDate.text = "02/02"
        textViewCardMinTemp.text = itemView.context.getString(R.id.minTempCard,cardDetail.forecastSummary.forecast.minTemp)
        textViewCardMaxTemp.text = cardDetail.forecastSummary.forecast.maxTemp.toString()
        textViewCardRainfall.text = cardDetail.forecastSummary.forecast.rainfall.toString()
        textViewCardWind.text = cardDetail.forecastSummary.forecast.wind.toString()
    }
}