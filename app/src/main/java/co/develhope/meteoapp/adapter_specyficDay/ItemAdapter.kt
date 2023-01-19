package co.develhope.meteoapp.adapter_specyficDay

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.model_specyficDay.SealedClassSpecyfDay

class ItemAdapter(private val context: Context, private val dataset: List<SealedClassSpecyfDay>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        //--- title ---
        inner class TitleViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

            private val textViewTitle: TextView = view.findViewById(R.id.title_giorno)
            private val textViewTitle2: TextView = view.findViewById(R.id.title_data)

            fun bind (detailsTitle: SealedClassSpecyfDay.DetailsTitle) {
                textViewTitle.text = context.resources.getString(detailsTitle.titleGiorno)
                textViewTitle2.text = context.resources.getString(detailsTitle.titleData)
            }
        }

        //--- row ---
        inner class RowViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

            private val textViewRow: TextView = view.findViewById(R.id.today_hour_textview)
            private val imageViewRow: ImageView = view.findViewById(R.id.icon_weather_imageview)
            private val textViewRow2: TextView = view.findViewById(R.id.temperature_textview)
            private val textViewRow3: TextView = view.findViewById(R.id.humidity_textview)

            fun bind (detailsRow: SealedClassSpecyfDay.DetailsRow) {
                textViewRow.text = context.resources.getString(detailsRow.todayHour)
                imageViewRow.setImageResource(detailsRow.iconWeather)
                textViewRow2.text = context.resources.getString(detailsRow.temperature)
                textViewRow3.text = context.resources.getString(detailsRow.humidity)
            }
        }

    //--- card ---
    inner class CardViewHolder(private val view: View) : RecyclerView.ViewHolder(view){

        private val textViewCard: TextView= view.findViewById(R.id.val_percep)
        private val textViewCard2: TextView= view.findViewById(R.id.val_umidità)
        private val textViewCard3: TextView= view.findViewById(R.id.val_copertura)
        private val textViewCard4: TextView= view.findViewById(R.id.val_UV)
        private val textViewCard5: TextView= view.findViewById(R.id.val_vento)
        private val textViewCard6: TextView= view.findViewById(R.id.val_pioggia)

        fun bind (detailsCard: SealedClassSpecyfDay.DetailsCard)  {
            textViewCard.text = context.resources.getString(detailsCard.datoValPercep)
            textViewCard2.text = context.resources.getString(detailsCard.datoValUV)
            textViewCard3.text = context.resources.getString(detailsCard.datoValUmidità)
            textViewCard4.text = context.resources.getString(detailsCard.datoValVento)
            textViewCard5.text = context.resources.getString(detailsCard.datoValCopertura)
            textViewCard6.text = context.resources.getString(detailsCard.datoValPioggia)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}
