package co.develhope.meteoapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.adapter.RecentSearchAdapter
import co.develhope.meteoapp.data.RecentSearchDataSet
import co.develhope.meteoapp.databinding.FragmentSearchBinding
import co.develhope.meteoapp.model.RecentSearch


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



        val adapter = RecentSearchAdapter(RecentSearchDataSet.loadRecentSearch())
        binding.recentsearchlist.adapter = adapter
        binding.recentsearchlist.layoutManager = LinearLayoutManager(view.context)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}