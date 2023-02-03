package co.develhope.meteoapp.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.HomeScreenItems
import co.develhope.meteoapp.databinding.CardHomeScreenBinding
import co.develhope.meteoapp.databinding.TitleHomeScreenItemBinding

class CardViewHolder(private val binding: CardHomeScreenBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(cardDetail: HomeScreenItems.Forecast) {
        binding.dayCard.text = "Lunedì"
        binding.dateCard.text = "02/02"
        binding.minTempCard.text = itemView.context.getString(R.string.tempMin, cardDetail.forecastSummary.forecast.minTemp.toString())
        binding.maxTempCard.text = itemView.context.getString(R.string.tempMax, cardDetail.forecastSummary.forecast.maxTemp.toString())
        binding.rainfallPercent.text = itemView.context.getString(R.string.rainfallPercent, cardDetail.forecastSummary.forecast.rainfall.toString())
        binding.windKmhCard.text = itemView.context.getString(R.string.windKmh, cardDetail.forecastSummary.forecast.wind.toString())







    }



}