package co.develhope.meteoapp.specificDay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.adapter_specyficDay.ItemAdapter
import co.develhope.meteoapp.data_specyficDay.DatasourceSpecificDay.loadSealedClass
import co.develhope.meteoapp.databinding.FragmentSpecificDayBinding


/**
 * A simple [Fragment] subclass.
 * Use the [SpecificDayFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpecificDayFragment : Fragment() {


    private var _binding: FragmentSpecificDayBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpecificDayBinding.inflate(inflater,container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        val adapter1 = ItemAdapter(0, loadSealedClass())
        binding.recyclerView.adapter = adapter1
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        val adapter2 = ItemAdapter(1, loadSealedClass())
        binding.recyclerView.adapter = adapter2
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        val adapter3 = ItemAdapter(2, loadSealedClass())
        binding.recyclerView.adapter = adapter3
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}









