package co.develhope.meteoapp.ui.adapter.homescreen

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.domainmodel.WeatherCondition
import co.develhope.meteoapp.databinding.CardHomeScreenBinding

class CardViewHolder(private val binding: CardHomeScreenBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(cardDetail: HomeScreenItems.Forecast) {
        binding.dayCard.text = "Oggi"
        binding.dateCard.text = itemView.context.getString(R.string.date, "${cardDetail.forecastSummary.date.dayOfMonth}/${cardDetail.forecastSummary.date.monthValue}")
        binding.minTempCard.text = itemView.context.getString(R.string.tempMin, cardDetail.forecastSummary.forecast.minTemp.toString())
        binding.maxTempCard.text = itemView.context.getString(R.string.tempMax, cardDetail.forecastSummary.forecast.maxTemp.toString())
        binding.rainfallPercent.text = itemView.context.getString(R.string.rainfallPercent, cardDetail.forecastSummary.forecast.rainfall.toString())
        binding.windKmhCard.text = itemView.context.getString(R.string.windKmh, cardDetail.forecastSummary.forecast.wind.toString())
        binding.weathericon.setImageResource(decodeWeatherIcon(cardDetail.forecastSummary.forecast.weatherCondition))
    }

    private fun decodeWeatherIcon(weatherCondition: WeatherCondition) : Int {
        return when(weatherCondition){
            WeatherCondition.SUNNY -> R.drawable.sun_icon
            WeatherCondition.RAIN -> R.drawable.rain_icon
            else -> R.drawable.cloudy_icon
        }
    }



}