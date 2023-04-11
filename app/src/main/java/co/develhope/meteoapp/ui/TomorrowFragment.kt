package co.develhope.meteoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import co.develhope.meteoapp.MeteoApp
import co.develhope.meteoapp.R
import co.develhope.meteoapp.SpecificDayViewModel
import co.develhope.meteoapp.data.Datasource
import co.develhope.meteoapp.data.domainmodel.SpecyficDayForecastSummary
import co.develhope.meteoapp.data.domainmodel.TitleForecast
import co.develhope.meteoapp.databinding.FragmentSpecificDayBinding
import co.develhope.meteoapp.ui.adapter.specificday.SpecificDaayAdapter
import co.develhope.meteoapp.ui.adapter.specificday.SpecyfDayScreenItem
import dagger.hilt.android.AndroidEntryPoint
import org.threeten.bp.OffsetDateTime

@AndroidEntryPoint
class TomorrowFragment : Fragment() {

    private var _binding : FragmentSpecificDayBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel : SpecificDayViewModel

    val args : TomorrowFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpecificDayBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[SpecificDayViewModel::class.java]

        setupObserver()

        return binding.root
    }

    private fun setupObserver() {
        if (MeteoApp.preferences?.getCurrentPlace() == null) {
            findNavController().navigate(R.id.action_specificDayFragment_to_searchFragment)
        } else {

            viewModel.getSpecificSummary(
                MeteoApp.preferences?.getCurrentPlace()!!,
                selectDate()
            )

            viewModel.specificDayForecastList.observe(viewLifecycleOwner) {
                val specificDayItem: List<SpecyfDayScreenItem> = createSpecyfDayScreenItem(it)
                val adapter = SpecificDaayAdapter(specificDayItem)
                binding.recyclerView.adapter = adapter
            }
        }
    }

    private fun selectDate() : OffsetDateTime {
        val selectedDate = args.date.toString()
        return when(selectedDate){
            "tomorrow" -> OffsetDateTime.now().plusDays(1)
            else -> {
                return OffsetDateTime.parse(selectedDate)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun createSpecyfDayScreenItem(forecastSummaryList: List<SpecyficDayForecastSummary>): List<SpecyfDayScreenItem> {
        val listShowItem = mutableListOf<SpecyfDayScreenItem>()
        val filterLists =
            forecastSummaryList.filter{ specyficDayForecastSummary -> specyficDayForecastSummary.row.time.isAfter(
                Datasource.getTime()
            )  }
        listShowItem.add(
            SpecyfDayScreenItem.DetailsTitle(
                TitleForecast(MeteoApp.preferences?.getCurrentPlace()!!, selectDate())
            ))
        listShowItem.addAll(filterLists.map { SpecyfDayScreenItem.DetailsRow(it) })
        return listShowItem
    }
}