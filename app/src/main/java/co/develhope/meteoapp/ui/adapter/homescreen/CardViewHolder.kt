package co.develhope.meteoapp.ui.adapter.homescreen

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.CardHomeScreenBinding
import co.develhope.meteoapp.ui.utils.decodeWeatherIcon
import co.develhope.meteoapp.ui.utils.getDayItaVersion

class CardViewHolder(private val binding: CardHomeScreenBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(cardDetail: HomeScreenItems.Forecast,position:Int,  listener : OnClickCardItem) {
        binding.dayCard.text = getDayItaVersion(cardDetail.forecastSummary.forecast.date.dayOfWeek.name)
        binding.dateCard.text = itemView.context.getString(R.string.date, "${cardDetail.forecastSummary.date.dayOfMonth}/${cardDetail.forecastSummary.date.monthValue}")
        binding.minTempCard.text = itemView.context.getString(R.string.tempMin, cardDetail.forecastSummary.forecast.minTemp.toString())
        binding.maxTempCard.text = itemView.context.getString(R.string.tempMax, cardDetail.forecastSummary.forecast.maxTemp.toString())
        binding.rainfallPercent.text = itemView.context.getString(R.string.rainfallPercent, cardDetail.forecastSummary.forecast.rainfall.toString())
        binding.windKmhCard.text = itemView.context.getString(R.string.windKmh, cardDetail.forecastSummary.forecast.wind.toString())
        binding.weathericon.setImageResource(decodeWeatherIcon(cardDetail.forecastSummary.forecast.weatherCondition))
        binding.cardHomeScreen.setOnClickListener{
            listener.onCLickCard(cardDetail,position)
        }
    }









}