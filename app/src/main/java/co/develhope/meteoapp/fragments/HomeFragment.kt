package co.develhope.meteoapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.HomeScreenAdapter
import co.develhope.meteoapp.data.DatasourceHomeScreen
import co.develhope.meteoapp.databinding.FragmentHomeScreenBinding


class HomeFragment : Fragment() {
    private var bindingHomeScreen: FragmentHomeScreenBinding? = null
    private val binding get() = bindingHomeScreen!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingHomeScreen = FragmentHomeScreenBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = HomeScreenAdapter(DatasourceHomeScreen.loadData())
        binding.recycleViewHomeScreen.adapter = adapter
        binding.recycleViewHomeScreen.layoutManager = LinearLayoutManager(view.context)


    }
}