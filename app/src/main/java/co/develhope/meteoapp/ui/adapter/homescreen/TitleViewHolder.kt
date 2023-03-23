package co.develhope.meteoapp.ui.adapter.homescreen

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.MeteoApp
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Datasource
import co.develhope.meteoapp.databinding.TitleHomeScreenItemBinding

class TitleViewHolder(private val binding: TitleHomeScreenItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(title: HomeScreenItems.HomeScreenTitle) {
        //%s, %s
        //context.getString(pippo, title.place.city, title.place.region
        binding.textTitleHomeScreen.text = "${MeteoApp.preferences?.getCurrentPlace()?.city}, ${MeteoApp.preferences?.getCurrentPlace()?.region}" ?: ""


    }
}