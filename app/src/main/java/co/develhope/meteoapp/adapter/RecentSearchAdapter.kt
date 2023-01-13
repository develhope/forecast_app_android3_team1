package co.develhope.meteoapp.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.model.RecentSearch


class RecentSearchAdapter(val data : List<RecentSearch>) : RecyclerView.Adapter<RecentSearchAdapter.ViewHolder>(){

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val nameCity : TextView
        val temperature : TextView
        val meteostate : TextView

        init {
            nameCity = view.findViewById(R.id.citynametextview)
            temperature = view.findViewById(R.id.temperaturetextview)
            meteostate = view.findViewById(R.id.meteostatetextview)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recent_search_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameCity.text = data[position].cityName
        holder.temperature.text = data[position].temperature + "°"
        holder.meteostate.text = data[position].state
    }

    override fun getItemCount(): Int {
        return data.size
    }


}