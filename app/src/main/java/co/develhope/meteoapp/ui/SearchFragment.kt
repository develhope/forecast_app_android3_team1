package co.develhope.meteoapp.ui

import android.os.Bundle
import android.provider.ContactsContract.Data
import android.text.Editable
import android.text.TextWatcher
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

    private lateinit var adapter : SearchAdapter

    private lateinit var recentSearch : List<Place>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater,container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recentSearch = Datasource.loadRecentSearch()
        adapter = SearchAdapter(transformDataForSearchAdapter(recentSearch))
        binding.recentsearchlist.adapter = adapter
        binding.recentsearchlist.layoutManager = LinearLayoutManager(view.context)

        //register listener for search location
        searchLocation()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun transformDataForSearchAdapter(list : List<Place>) : List<SearchScreenItems> {
        val recentSearchList = mutableListOf<SearchScreenItems>()
        recentSearchList.add(SearchScreenItems.RecentSearchTitle(requireContext().getString(R.string.ricerche_recenti)))
        list.forEach {
            recentSearchList.add(SearchScreenItems.RecentSearch(it))
        }
        return recentSearchList
    }


    private fun searchLocation() {
        binding.searchBarLocation.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val filteredRecentSearch = recentSearch.filter {
                    it.city.contains(s.toString().toRegex(setOf(RegexOption.IGNORE_CASE )))
                }
                adapter = SearchAdapter(transformDataForSearchAdapter(filteredRecentSearch))
                binding.recentsearchlist.adapter = adapter
                adapter.notifyDataSetChanged()
            }

        })
    }
}