package co.develhope.meteoapp.specificDay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.adapter_specyficDay.ItemAdapter
import co.develhope.meteoapp.data_specyficDay.DatasourceSpecificDay
import co.develhope.meteoapp.data_specyficDay.SpecyficDayForecastSummary
import co.develhope.meteoapp.databinding.FragmentSpecificDayBinding
import co.develhope.meteoapp.model_specyficDay.SpecyfDayScreenItem


class SpecificDayFragment : Fragment() {


    private var _binding: FragmentSpecificDayBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpecificDayBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val forecastSummaryList = DatasourceSpecificDay.loadData()
        val createdList = createSpecyfDayScreenItem(forecastSummaryList)

        val adapter = ItemAdapter(createdList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)


    }

    private fun createSpecyfDayScreenItem(forecastSummaryList: List<SpecyficDayForecastSummary>): List<SpecyfDayScreenItem> {
        val listShowItem = mutableListOf<SpecyfDayScreenItem>()

        listShowItem.add(SpecyfDayScreenItem.DetailsTitle(forecastSummaryList.first().title))
        listShowItem.add(SpecyfDayScreenItem.DetailsRow(forecastSummaryList.first()))
        listShowItem.add(SpecyfDayScreenItem.DetailsCard(forecastSummaryList.first().card))

        listShowItem.addAll(forecastSummaryList.map { SpecyfDayScreenItem.DetailsRow(it) })

        return listShowItem
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}











