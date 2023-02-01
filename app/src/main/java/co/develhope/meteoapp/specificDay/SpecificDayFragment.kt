package co.develhope.meteoapp.specificDay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.R
import co.develhope.meteoapp.adapter_specyficDay.ItemAdapter
import co.develhope.meteoapp.adapter_specyficDay.TitleViewHolder
import co.develhope.meteoapp.data_specyficDay.DataClassForecast
import co.develhope.meteoapp.data_specyficDay.DatasourceSpecificDay
import co.develhope.meteoapp.databinding.FragmentSpecificDayBinding
import kotlinx.coroutines.NonDisposableHandle.parent

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

        val adapter = ItemAdapter(DatasourceSpecificDay.loadData())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}









