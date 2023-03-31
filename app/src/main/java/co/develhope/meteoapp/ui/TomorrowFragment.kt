package co.develhope.meteoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import co.develhope.meteoapp.SpecificDayViewModel
import co.develhope.meteoapp.databinding.FragmentSpecificDayBinding

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
        return binding.root
    }
}