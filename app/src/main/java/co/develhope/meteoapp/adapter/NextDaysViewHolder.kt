package co.develhope.meteoapp.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R

class NextDaysViewHolder(private val view : View) : RecyclerView.ViewHolder(view) {
    private val textViewNextDays : TextView = view.findViewById(R.id.next5Days)

    fun bind(next5Days : HomeScreenItem.NextDays){
        textViewNextDays.text = next5Days.nextDays.nextDays.toString()
    }
}