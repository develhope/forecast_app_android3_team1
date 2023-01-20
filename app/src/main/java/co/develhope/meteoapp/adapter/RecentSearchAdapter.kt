package co.develhope.meteoapp.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.RecentSearchDataSet


import co.develhope.meteoapp.model.RecyclerViewData

const val SEARCHITEM = 1
const val SEARCHTITLE = 0


class RecentSearchAdapter(val data: List<RecyclerViewData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class RecentSearchTitleHolder(view : View) : RecyclerView.ViewHolder(view){
        private val title = view.findViewById<TextView>(R.id.recent_search_title)

        fun bind(searchtitle : RecyclerViewData.RecentSearchTitle){
           title.text = searchtitle.title
        }
    }

    class SearchTermViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val searchTerm = view.findViewById<TextView>(R.id.citynametextview)

        fun bind(city : RecyclerViewData.RecentSearch){
            searchTerm.text = city.cityName
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(data[position]){
            is RecyclerViewData.RecentSearch -> 1
            is RecyclerViewData.RecentSearchTitle -> 0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
             SEARCHTITLE -> RecentSearchTitleHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.recent_search_title, parent, false)
             )
             SEARCHITEM -> SearchTermViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.recent_search_item, parent, false)
             )

            else -> SearchTermViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.recent_search_item, parent, false)
            )

        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is RecentSearchTitleHolder -> holder.bind(data[position] as RecyclerViewData.RecentSearchTitle)
            is SearchTermViewHolder -> holder.bind(data[position] as RecyclerViewData.RecentSearch)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }


}