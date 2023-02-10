package co.develhope.meteoapp.ui.adapter.homescreen

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.HomeScreenItems
import co.develhope.meteoapp.databinding.CardHomeScreenBinding

class CardViewHolder(private val binding: CardHomeScreenBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(cardDetail: HomeScreenItems.Forecast) {
        binding.dayCard.text = "Oggi"
        binding.dateCard.text = itemView.context.getString(R.string.date, cardDetail.forecastSummary.date)
        binding.minTempCard.text = itemView.context.getString(R.string.tempMin, cardDetail.forecastSummary.forecast.minTemp.toString())
        binding.maxTempCard.text = itemView.context.getString(R.string.tempMax, cardDetail.forecastSummary.forecast.maxTemp.toString())
        binding.rainfallPercent.text = itemView.context.getString(R.string.rainfallPercent, cardDetail.forecastSummary.forecast.rainfall.toString())
        binding.windKmhCard.text = itemView.context.getString(R.string.windKmh, cardDetail.forecastSummary.forecast.wind.toString())







    }



}