package co.develhope.meteoapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Datasource
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.databinding.FragmentSearchBinding
import co.develhope.meteoapp.ui.adapter.searchscreen.SearchAdapter
import co.develhope.meteoapp.ui.adapter.searchscreen.SearchScreenItems


class SearchFragment : Fragment() {


    private var _binding : FragmentSearchBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater,container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        val adapter = SearchAdapter(transformDataForSearchAdapter(Datasource.loadRecentSearch()))
        binding.recentsearchlist.adapter = adapter
        binding.recentsearchlist.layoutManager = LinearLayoutManager(view.context)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun transformDataForSearchAdapter(list : List<Place>) : List<SearchScreenItems> {
        val recentSearchList = mutableListOf<SearchScreenItems>()
        recentSearchList.add(SearchScreenItems.RecentSearchTitle(requireContext().getString(R.string.recent_search)))
        list.forEach {
            recentSearchList.add(SearchScreenItems.RecentSearch(it))
        }
        return recentSearchList
    }


}