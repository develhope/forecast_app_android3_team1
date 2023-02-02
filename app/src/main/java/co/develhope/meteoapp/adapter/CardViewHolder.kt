package co.develhope.meteoapp.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R

class CardViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val textViewCardMinTemp: TextView = view.findViewById(R.id.minTempCard)
    private val textViewCardMaxTemp: TextView = view.findViewById(R.id.maxTempCard)
    private val textViewCardDate: TextView = view.findViewById(R.id.dateCard)
    private val textViewCardRainfall: TextView = view.findViewById(R.id.rainfallPercent)
    private val textViewCardWind: TextView = view.findViewById(R.id.windKmhCard)


    fun bind(cardDetail: HomeScreenItem.ForecastDetail) {
        textViewCardDate.text = cardDetail.forecastDetail.date.toString()
        textViewCardMinTemp.text = cardDetail.forecastDetail.minTemp.toString()
        textViewCardMaxTemp.text = cardDetail.forecastDetail.maxTemp.toString()
        textViewCardRainfall.text = cardDetail.forecastDetail.rainfall.toString()
        textViewCardWind.text = cardDetail.forecastDetail.wind.toString()
    }
}