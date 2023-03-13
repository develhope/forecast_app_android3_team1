package co.develhope.meteoapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.R
import co.develhope.meteoapp.ui.adapter.homescreen.HomeScreenAdapter
import co.develhope.meteoapp.data.Datasource
import co.develhope.meteoapp.data.domainmodel.DailyForecastSummary
import co.develhope.meteoapp.data.domainmodel.Forecast
import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.ui.adapter.homescreen.HomeScreenItems
import co.develhope.meteoapp.databinding.FragmentHomeScreenBinding
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.network.dto.HomeSummary
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import co.develhope.meteoapp.ui.adapter.homescreen.OnClickCardItem


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

    override fun onStart() {
        super.onStart()
        if(Datasource.getPlace() == null){
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }else{
            getDailySummary()
        }
    }

    private fun showForecastInHome(forecastSummaryList: List<DailyForecastSummary>) {
        val listCreated = createHomeScreenItems(forecastSummaryList)

        val adapter = HomeScreenAdapter(listCreated, object: OnClickCardItem{
            override fun onCLickCard(cardDetail: HomeScreenItems.Forecast, position: Int) {

                findNavController().navigate(R.id.action_homeFragment_to_specificDayFragment)
            }
        })
        binding.recycleViewHomeScreen.adapter = adapter
        binding.recycleViewHomeScreen.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun createHomeScreenItems(forecastSummaryList: List<DailyForecastSummary>): List<HomeScreenItems> {
        val listToShow = mutableListOf<HomeScreenItems>()
        listToShow.add(HomeScreenItems.HomeScreenTitle(forecastSummaryList.first().place))
        listToShow.add(HomeScreenItems.Forecast(forecastSummaryList.first()))
        listToShow.add(HomeScreenItems.NextDays)

        listToShow.addAll(
            forecastSummaryList.map {
                HomeScreenItems.Forecast(it)
            }
        )
        listToShow.removeAt(3)
        listToShow.removeLast()
        return listToShow
    }

    private fun getDailySummary() {
        if (Datasource.getPlace() != null) {
            lifecycleScope.launch {
                val result = NetworkProvider().getDailySummary(Datasource.getPlace()!!)
                
                val forecasts: List<Forecast> = result.toDomain()

                val forecastSummaryList: List<DailyForecastSummary> =
                    forecasts.mapIndexed { index, forecast ->
                        DailyForecastSummary(
                            Datasource.getPlace()!!,
                            date = forecast.date,
                            forecast = forecast
                        )
                    }
                showForecastInHome(forecastSummaryList)
            }
        }
    }
}