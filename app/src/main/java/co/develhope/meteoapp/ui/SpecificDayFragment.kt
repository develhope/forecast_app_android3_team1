package co.develhope.meteoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.MeteoApp
import co.develhope.meteoapp.R
import co.develhope.meteoapp.SpecificDayViewModel
import co.develhope.meteoapp.data.Datasource
import co.develhope.meteoapp.data.Datasource.getSelectedDate
import co.develhope.meteoapp.data.Datasource.getTime

import co.develhope.meteoapp.data.domainmodel.*
import co.develhope.meteoapp.databinding.FragmentSpecificDayBinding
import co.develhope.meteoapp.ui.adapter.specificday.SpecificDaayAdapter
import co.develhope.meteoapp.ui.adapter.specificday.SpecyfDayScreenItem

class SpecificDayFragment : Fragment() {

    private var _binding: FragmentSpecificDayBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SpecificDayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpecificDayBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[SpecificDayViewModel::class.java]

        super.onStart()
        if(MeteoApp.preferences?.getCurrentPlace() == null){
            findNavController().navigate(R.id.action_specificDayFragment_to_searchFragment)
        }else{
            viewModel.getTitleForecast(MeteoApp.preferences?.getCurrentPlace()!! , getSelectedDate())
            viewModel.getSpecificSummary(MeteoApp.preferences?.getCurrentPlace()!!, getSelectedDate())

            viewModel.specificDayForecastList.observe(viewLifecycleOwner){
                val specificDayItem: List<SpecyfDayScreenItem> = createSpecyfDayScreenItem(it)
                val adapter = SpecificDaayAdapter(specificDayItem)
                binding.recyclerView.adapter = adapter
            }
        }
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
//in VM
    private fun createSpecyfDayScreenItem(forecastSummaryList: List<SpecyficDayForecastSummary>): List<SpecyfDayScreenItem> {
        val listShowItem = mutableListOf<SpecyfDayScreenItem>()

        val filterLists =
            forecastSummaryList.filter{ specyficDayForecastSummary -> specyficDayForecastSummary.row.time.isAfter(getTime())  }

        listShowItem.add(SpecyfDayScreenItem.DetailsTitle(
            TitleForecast(MeteoApp.preferences?.getCurrentPlace()!!, getSelectedDate())))



        listShowItem.addAll(filterLists.map { SpecyfDayScreenItem.DetailsRow(it) })

        return listShowItem
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

