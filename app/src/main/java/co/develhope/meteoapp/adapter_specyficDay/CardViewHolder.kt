package co.develhope.meteoapp.adapter_specyficDay

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.model_specyficDay.SpecyfDayScreenItem


//--- card ---
class CardViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val textViewCard: TextView = view.findViewById(R.id.val_percep)
    private val textViewCard2: TextView = view.findViewById(R.id.val_umidità)
    private val textViewCard3: TextView = view.findViewById(R.id.val_copertura)
    private val textViewCard4: TextView = view.findViewById(R.id.val_UV)
    private val textViewCard5: TextView = view.findViewById(R.id.val_vento)
    private val textViewCard6: TextView = view.findViewById(R.id.val_pioggia)

    fun bind(detailsCard: SpecyfDayScreenItem.DetailsCard) {
        textViewCard.text = itemView.context.getString(R.string.simbol_gradi, detailsCard.cardForecast.percepita.toString())
        textViewCard2.text = itemView.context.getString(R.string.simbol_percentuale, detailsCard.cardForecast.uv.toString())
        textViewCard3.text = itemView.context.getString(R.string.simbol_percentuale, detailsCard.cardForecast.humidity.toString())
        textViewCard4.text = itemView.context.getString(R.string.simbol_UV,detailsCard.cardForecast.vento.toString())
        textViewCard5.text = itemView.context.getString(R.string.simbol_SSE, detailsCard.cardForecast.copertura.toString())
        textViewCard6.text = itemView.context.getString(R.string.simbol_cm, detailsCard.cardForecast.pioggia.toString())
    }
}