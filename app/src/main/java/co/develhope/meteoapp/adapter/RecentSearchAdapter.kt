package co.develhope.meteoapp.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.RecentSearchItemBinding
import co.develhope.meteoapp.model.RecentSearch


class RecentSearchAdapter(val data : List<RecentSearch>) : RecyclerView.Adapter<RecentSearchAdapter.ViewHolder>(){

    private lateinit var _binding : RecentSearchItemBinding

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        _binding = RecentSearchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.recent_search_item,parent,false)
        return ViewHolder(_binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        _binding.citynametextview.text = data[position].cityName

    }

    override fun getItemCount(): Int {
        return data.size
    }


}