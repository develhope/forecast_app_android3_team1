package co.develhope.meteoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import co.develhope.meteoapp.MeteoApp
import co.develhope.meteoapp.R
import co.develhope.meteoapp.SpecificDayViewModel
import co.develhope.meteoapp.data.Datasource
import co.develhope.meteoapp.databinding.FragmentSpecificDayBinding
import co.develhope.meteoapp.ui.adapter.specificday.SpecificDaayAdapter
import co.develhope.meteoapp.ui.adapter.specificday.SpecyfDayScreenItem
import co.develhope.meteoapp.ui.utils.createSpecyfDayScreenItem
import org.threeten.bp.OffsetDateTime

class TomorrowFragment : Fragment() {

    private var _binding : FragmentSpecificDayBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel : SpecificDayViewModel

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
                OffsetDateTime.now().plusDays(1)
            )

            viewModel.specificDayForecastList.observe(viewLifecycleOwner) {
                val specificDayItem: List<SpecyfDayScreenItem> = createSpecyfDayScreenItem(it)
                val adapter = SpecificDaayAdapter(specificDayItem)
                binding.recyclerView.adapter = adapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}