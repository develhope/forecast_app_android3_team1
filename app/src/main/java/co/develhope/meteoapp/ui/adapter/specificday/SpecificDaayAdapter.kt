package co.develhope.meteoapp.ui.adapter.specificday

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.ui.adapter.homescreen.CardViewHolder

class SpecificDaayAdapter(private val dataset: List<SpecyfDayScreenItem>) :
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
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_row, parent, false
                    )
                )
            }
            else -> {
                Log.e("item adapter", "error type")
                throw java.lang.IllegalArgumentException("error")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TitleViewHolder -> holder.bind(dataset[position] as SpecyfDayScreenItem.DetailsTitle)
            is RowViewHolder -> holder.bind(dataset[position] as SpecyfDayScreenItem.DetailsRow)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}
