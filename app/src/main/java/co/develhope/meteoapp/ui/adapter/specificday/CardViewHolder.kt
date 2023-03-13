package co.develhope.meteoapp.ui.adapter.specificday

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R


//--- card ---
class CardViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val percepitaCard: TextView = view.findViewById(R.id.val_percep)
    private val umiditàCard: TextView = view.findViewById(R.id.val_umidità)
    private val coperturaCard: TextView = view.findViewById(R.id.val_copertura)
    private val uvCard: TextView = view.findViewById(R.id.val_UV)
    private val ventoCard: TextView = view.findViewById(R.id.val_vento)
    private val pioggiaCard: TextView = view.findViewById(R.id.val_pioggia)

    fun bind(detailsCard: SpecyfDayScreenItem.DetailsCard) {
        percepitaCard.text = itemView.context.getString(R.string.simbol_gradi, detailsCard.cardForecast.percepita.toString())
        umiditàCard.text = itemView.context.getString(R.string.simbol_percentuale, detailsCard.cardForecast.humidity.toString())
        coperturaCard.text = itemView.context.getString(R.string.simbol_percentuale, detailsCard.cardForecast.copertura.toString())
        uvCard.text = itemView.context.getString(R.string.simbol_UV,detailsCard.cardForecast.uv.toString())
        ventoCard.text = itemView.context.getString(R.string.simbol_SSE, detailsCard.cardForecast.vento.toString())
        pioggiaCard.text = itemView.context.getString(R.string.simbol_cm, detailsCard.cardForecast.pioggia.toString())
    }
}