package co.develhope.meteoapp.adapter_specyficDay

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.model_specyficDay.DetailsDay

class ItemAdapter(private val context: Context, private val dataset: List<DetailsDay>): RecyclerView.Adapter<ItemAdapter.ItamViewHolder>() {
    class ItamViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.today_hour_textview)
        val imageView: ImageView = view.findViewById(R.id.icon_weather_imageview)
        val textView2: TextView = view.findViewById(R.id.temperature_textview)
        val textView3: TextView = view.findViewById(R.id.humidity_textview)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItamViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ItamViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
