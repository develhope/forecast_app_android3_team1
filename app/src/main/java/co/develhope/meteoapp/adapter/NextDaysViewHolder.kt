package co.develhope.meteoapp.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.HomeScreenItems
import co.develhope.meteoapp.databinding.Next5daysHomeScreenItemBinding
import co.develhope.meteoapp.databinding.TitleHomeScreenItemBinding

class NextDaysViewHolder(private val binding: Next5daysHomeScreenItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(next5Days : HomeScreenItems.NextDays){
        //view.context.getString()
        binding.next5Days.text = itemView.context.getString(R.string.next_days)
    }
}