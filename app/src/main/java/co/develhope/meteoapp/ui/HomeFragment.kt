package co.develhope.meteoapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.HomeViewModel
import co.develhope.meteoapp.MeteoApp
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.FragmentHomeScreenBinding
import co.develhope.meteoapp.ui.adapter.homescreen.HomeScreenAdapter
import co.develhope.meteoapp.ui.adapter.homescreen.HomeScreenItems
import co.develhope.meteoapp.ui.adapter.homescreen.OnClickCardItem


class HomeFragment : Fragment() {
    private var bindingHomeScreen: FragmentHomeScreenBinding? = null
    private val binding get() = bindingHomeScreen!!
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingHomeScreen = FragmentHomeScreenBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        val view = binding.root
        return view
    }

    override fun onStart() {
        super.onStart()
        if(MeteoApp.preferences?.getCurrentPlace() == null){
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }else{
            Log.d("Current Place home: " , "${MeteoApp.preferences?.getCurrentPlace()}")
            viewModel.getDailySummary()
        }
        viewModel.homeForecastList.observe(viewLifecycleOwner){
            val homeItem: List<HomeScreenItems> = viewModel.createHomeScreenItems(it)
            val adapter = HomeScreenAdapter(homeItem, object: OnClickCardItem{
                override fun onCLickCard(cardDetail: HomeScreenItems.Forecast, position: Int) {
                    val action = HomeFragmentDirections.actionHomeFragmentToTomorrowFragment(
                        cardDetail.forecastSummary.date.toString()
                    )
                    findNavController().navigate(action)

                }
            })
            binding.recycleViewHomeScreen.adapter = adapter
        }
        binding.recycleViewHomeScreen.layoutManager = LinearLayoutManager(requireContext())
    }


}