package co.develhope.meteoapp.ui.adapter.homescreen

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.Next5daysHomeScreenItemBinding

class NextDaysViewHolder(private val binding: Next5daysHomeScreenItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(){
        //view.context.getString()
        binding.next5Days.text = itemView.context.getString(R.string.next_days)
    }
}