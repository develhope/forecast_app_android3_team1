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
import co.develhope.meteoapp.data.MeteoGetPreferencesEvent
import co.develhope.meteoapp.data.PlaceResources
import co.develhope.meteoapp.databinding.FragmentHomeScreenBinding
import co.develhope.meteoapp.network.isOnline
import co.develhope.meteoapp.ui.adapter.homescreen.HomeScreenAdapter
import co.develhope.meteoapp.ui.adapter.homescreen.HomeScreenItems
import co.develhope.meteoapp.ui.adapter.homescreen.OnClickCardItem
import co.develhope.meteoapp.ui.dialog.InternetConnectionDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        val currentPlace = viewModel.onGetPreferencesResource(MeteoGetPreferencesEvent.GetCurrentPlaceEvent())
        if(currentPlace is PlaceResources.Failed){
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }else{
            if(isOnline(requireContext())) {
                viewModel.getDailySummary()
            }else{
                Log.d("Connection Problems", "No connection")
                val dialog = InternetConnectionDialog(requireContext())
                dialog.show(childFragmentManager, "")
            }
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