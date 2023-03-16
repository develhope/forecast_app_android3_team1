package co.develhope.meteoapp.ui.adapter.searchscreen


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.domainmodel.Place

const val SEARCHITEM = 1
const val SEARCHTITLE = 0


class SearchAdapter(var data: List<SearchScreenItems>, val onItemClick : (Place) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {





    override fun getItemViewType(position: Int): Int {
        return when(data[position]){
            is SearchScreenItems.RecentSearch -> 1
            is SearchScreenItems.RecentSearchTitle -> 0
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
            is RecentSearchTitleHolder -> holder.bind(data[position] as SearchScreenItems.RecentSearchTitle)
            is SearchTermViewHolder -> holder.bind(data[position] as SearchScreenItems.RecentSearch, onItemClick )
        }

    }



    override fun getItemCount(): Int {
        return data.size
    }


}