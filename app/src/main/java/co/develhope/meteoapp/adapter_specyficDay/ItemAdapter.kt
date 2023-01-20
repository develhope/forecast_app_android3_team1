package co.develhope.meteoapp.adapter_specyficDay

import android.content.Context
import android.icu.text.CaseMap
import android.system.Os.bind
import android.util.Log
import android.view.LayoutInflater
import android.view.LayoutInflater.*
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.model_specyficDay.SealedClassSpecyfDay

class ItemAdapter(private val context: Context, private val dataset: List<SealedClassSpecyfDay>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //--- segnalibro ---
    private val TYPE_SPECYFIC_DAY_TITLE = 0
    private val TYPE_SPECYFIC_DAY_ROW = 1
    private val TYPE_SPECYFIC_DAY_CARD = 2

    override fun getItemViewType(position: Int): Int {
        return when (dataset[position]) {
            is SealedClassSpecyfDay.DetailsTitle -> TYPE_SPECYFIC_DAY_TITLE
            is SealedClassSpecyfDay.DetailsRow -> TYPE_SPECYFIC_DAY_ROW
            is SealedClassSpecyfDay.DetailsCard -> TYPE_SPECYFIC_DAY_CARD
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_SPECYFIC_DAY_TITLE -> {
                TitleViewHolder(

                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_title,
                        parent, false
                    )
                )
            }

            TYPE_SPECYFIC_DAY_ROW -> {
                RowViewHolder(

                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_row,
                        parent, false
                    )
                )
            }

            TYPE_SPECYFIC_DAY_CARD -> {
                CardViewHolder(

                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_card,
                        parent, false
                    )
                )
            }
            else -> {
                Log.e("item adapter", "error type")
                CardViewHolder(

                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_title,
                        parent, false
                    )
                ) //cambiare
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TitleViewHolder -> holder.bind(dataset[position] as SealedClassSpecyfDay.DetailsTitle)
            is CardViewHolder -> holder.bind(dataset[position] as SealedClassSpecyfDay.DetailsCard)
            is RowViewHolder -> holder.bind(dataset[position] as SealedClassSpecyfDay.DetailsRow)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}
