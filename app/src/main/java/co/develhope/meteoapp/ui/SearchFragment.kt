package co.develhope.meteoapp.ui

import android.os.Bundle
import android.provider.ContactsContract.Data
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.MeteoApp
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Datasource
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.databinding.FragmentSearchBinding
import co.develhope.meteoapp.ui.adapter.searchscreen.SearchAdapter
import co.develhope.meteoapp.ui.adapter.searchscreen.SearchScreenItems
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {


    private var _binding : FragmentSearchBinding? = null
    val binding get() = _binding!!

    private lateinit var viewModel : SearchViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater,container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val  recentSearch = MeteoApp.preferences?.loadRecentSearch() ?: emptyList()
        setupAdapter(recentSearch)
        binding.recentsearchlist.layoutManager = LinearLayoutManager(view.context)
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        //register listener for search location
        searchLocation()
        viewModel.placeLocation.observe(viewLifecycleOwner){
            setupAdapter(it)
        }
    }

    override fun onResume() {
        super.onResume()
        setupAdapter(MeteoApp.preferences?.loadRecentSearch()!!)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    private fun transformDataForSearchAdapter(list : List<Place>) : List<SearchScreenItems> {
        val recentSearchList = mutableListOf<SearchScreenItems>()
        if(MeteoApp.preferences?.loadRecentSearch()!!.isNotEmpty()) {
            recentSearchList.add(SearchScreenItems.RecentSearchTitle(requireContext().getString(R.string.ricerche_recenti)))
        }
        list.forEach {
            recentSearchList.add(SearchScreenItems.RecentSearch(it))
        }
        return recentSearchList
    }

    private fun setupAdapter(places : List<Place>){
        val adapter : SearchAdapter = SearchAdapter(transformDataForSearchAdapter(places), selectPlace())
        binding.recentsearchlist.adapter = adapter
    }

//spostare nel ViewModel
    private fun updateRecentSearch(place: Place){
    val list = MeteoApp.preferences?.loadRecentSearch()?: emptyList()
    Log.d("Update","$list")
    val newList = list.toMutableList()
    newList.add(place)
    if(newList.size > 6){
        newList.removeFirst()
        MeteoApp.preferences?.saveRecentSearch(newList)
        return
    }
    MeteoApp.preferences?.saveRecentSearch(newList)
    Log.d("Updateshared","${MeteoApp.preferences?.loadRecentSearch()}")
    }

    private fun selectPlace(): (Place) -> Unit = {
        MeteoApp.preferences?.savePlace(place = it)
        updateRecentSearch(it)

        if(MeteoApp.preferences?.getCurrentPlace() != null){
            findNavController().navigate(R.id.action_searchFragment_to_homeFragment)
        }
    }


    private fun searchLocation() {
        binding.searchBarLocation.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if(count > before && !s.toString().isNullOrEmpty()){
                   viewModel.searchNetworkCall(s.toString(), requireContext().getString(R.string.language))

                }else if(count < before && !s.toString().isNullOrEmpty()) {

                    viewModel.searchNetworkCall(s.toString(), requireContext().getString(R.string.language))

                }


            }

            override fun afterTextChanged(s: Editable?) {
                if(s.toString().isNullOrEmpty() || s.toString().isBlank()){
                    setupAdapter(emptyList())
                }
            }

        })
    }
}