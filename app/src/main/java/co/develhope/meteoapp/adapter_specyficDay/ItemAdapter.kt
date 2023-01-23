package co.develhope.meteoapp.adapter_specyficDay

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.model_specyficDay.SealedClassSpecyfDay

class ItemAdapter(private val context: Int, private val dataset: List<SealedClassSpecyfDay>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return dataset[position].viewType

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                TitleViewHolder(

                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_title,
                        parent, false
                    )
                )
            }
            1 -> {
                RowViewHolder(
                    LayoutInflater.from(parent.context).inflate( R.layout.item_row, parent, false
                    )
                )
            }
            2 -> {
                CardViewHolder(
                    LayoutInflater.from(parent.context).inflate( R.layout.item_card, parent, false
                    )
                )
            }
            else -> {
                Log.e("item adapter", "error type")
                CardViewHolder(

                    LayoutInflater.from(parent.context).inflate( R.layout.item_blank, parent, false
                    )
                )
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
