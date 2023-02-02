package co.develhope.meteoapp.adapter

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.data.HomeScreenItems
import co.develhope.meteoapp.databinding.TitleHomeScreenItemBinding

class TitleViewHolder(private val binding: TitleHomeScreenItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(title: HomeScreenItems.HomeScreenTitle) {
        //%s, %s
        //context.getString(pippo, title.place.city, title.place.region
        binding.textTitleHomeScreen.text = "Palermo"//title.place.city
        binding.textTitleHomeScreen.text = title.place.region
    }
}