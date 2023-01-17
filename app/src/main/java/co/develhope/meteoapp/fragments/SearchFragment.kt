package co.develhope.meteoapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.adapter.RecentSearchAdapter
import co.develhope.meteoapp.data.RecentSearchDataSet
import co.develhope.meteoapp.model.RecentSearch


class SearchFragment : Fragment() {

    private lateinit var recentSearchList  :  List<RecentSearch>
    private lateinit var recentSearchRecyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        recentSearchList = RecentSearchDataSet.loadRecentSearch()
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recentSearchRecyclerView = view.findViewById(R.id.recentsearchlist)
        val adapter = RecentSearchAdapter(recentSearchList)
        recentSearchRecyclerView.adapter = adapter
        recentSearchRecyclerView.layoutManager = LinearLayoutManager(view.context)


    }


}