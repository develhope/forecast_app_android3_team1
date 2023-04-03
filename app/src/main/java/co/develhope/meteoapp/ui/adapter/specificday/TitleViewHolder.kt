package co.develhope.meteoapp.ui.adapter.specificday

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.ui.utils.getDayItaVersion
import co.develhope.meteoapp.ui.utils.getMonthItaVersion
import org.threeten.bp.OffsetDateTime

class TitleViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    //--- title ---
    private val dayTitle: TextView = view.findViewById(R.id.title_giorno)
    private val dataTitle: TextView = view.findViewById(R.id.title_data)
    private val placeTitle: TextView = view.findViewById(R.id.title_place)

    fun bind(detailsTitle: SpecyfDayScreenItem.DetailsTitle) {
        placeTitle.text =  "${detailsTitle.titleForecast.place.city},${detailsTitle.titleForecast.place.region}"
        dataTitle.text = setPlaceTitle(detailsTitle)
        dayTitle.text = setDay(detailsTitle.titleForecast.date)

    }

    private fun setDay(date : OffsetDateTime) : String {
        Log.d("Set Day date: " , "$date")
        return when (date.dayOfMonth) {
            OffsetDateTime.now().dayOfMonth -> {
                if(itemView.resources.getString(R.string.language).equals("it")){
                    dataTitle.text = itemView.context.getString(R.string.data_today, getDayItaVersion(date.dayOfWeek.name), date.dayOfMonth.toString(), getMonthItaVersion(date.month.name))
                }else{
                    dataTitle.text = itemView.context.getString(R.string.data_today, "", date.dayOfMonth.toString(), date.month.name)
                }
                view.resources.getString(R.string.todaylabel)
            }
            OffsetDateTime.now().plusDays(1).dayOfMonth -> {
                if(itemView.resources.getString(R.string.language).equals("it")){
                    dataTitle.text = itemView.context.getString(R.string.data_today, getDayItaVersion(date.dayOfWeek.name), date.dayOfMonth.toString(), getMonthItaVersion(date.month.name))
                }else{
                    dataTitle.text = itemView.context.getString(R.string.data_today, "", date.dayOfMonth.toString(), date.month.name)
                }
                view.resources.getString(R.string.tomorrowlabel)
            }
            else -> {
                dataTitle.text = itemView.context.getString(R.string.data_today, "", date.dayOfMonth.toString(), date.month.name)
                if(itemView.resources.getString(R.string.language).equals("it")){
                    dataTitle.text = itemView.context.getString(R.string.data_today, "", date.dayOfMonth.toString(), getMonthItaVersion(date.month.name))
                    itemView.context.getString(R.string.today, getDayItaVersion(date.dayOfWeek.name))
                }else{
                    dataTitle.text = itemView.context.getString(R.string.data_today, "", date.dayOfMonth.toString(), date.month.name)
                    itemView.context.getString(R.string.today, date.dayOfWeek.name)
                }
            }
        }
    }

    private fun setPlaceTitle(detailsTitle: SpecyfDayScreenItem.DetailsTitle) : String {
        if(itemView.resources.getString(R.string.language).equals("it")){
            return itemView.context.getString(R.string.data_today, detailsTitle.titleForecast.date.dayOfWeek.name, detailsTitle.titleForecast.date.dayOfMonth.toString(),
                getMonthItaVersion(detailsTitle.titleForecast.date.month.name))
        }else{
             return itemView.context.getString(R.string.data_today, detailsTitle.titleForecast.date.dayOfWeek.name, detailsTitle.titleForecast.date.dayOfMonth.toString(),
               detailsTitle.titleForecast.date.month.name)
        }
    }



}
