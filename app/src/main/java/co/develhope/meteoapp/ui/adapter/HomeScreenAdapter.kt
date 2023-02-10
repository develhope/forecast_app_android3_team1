package co.develhope.meteoapp.ui.adapter


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.adapter.CardViewHolder
import co.develhope.meteoapp.adapter.NextDaysViewHolder
import co.develhope.meteoapp.adapter.TitleViewHolder
import co.develhope.meteoapp.data.HomeScreenItems
import co.develhope.meteoapp.databinding.CardHomeScreenBinding
import co.develhope.meteoapp.databinding.Next5daysHomeScreenItemBinding
import co.develhope.meteoapp.databinding.TitleHomeScreenItemBinding

class HomeScreenAdapter(private val list: List<HomeScreenItems>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                TitleViewHolder(
                    TitleHomeScreenItemBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
            1 -> {
                CardViewHolder(
                    CardHomeScreenBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
            2 -> {
                NextDaysViewHolder(
                    Next5daysHomeScreenItemBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }

            else -> {
                throw java.lang.IllegalArgumentException("error")
            }
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TitleViewHolder -> holder.bind(list[position] as HomeScreenItems.HomeScreenTitle)
            is CardViewHolder -> holder.bind(list[position] as HomeScreenItems.Forecast)
            is NextDaysViewHolder -> holder.bind(list[position] as HomeScreenItems.NextDays)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
