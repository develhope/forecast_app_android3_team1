package co.develhope.meteoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.R
import co.develhope.meteoapp.ui.adapter.homescreen.HomeScreenAdapter
import co.develhope.meteoapp.data.Datasource
import co.develhope.meteoapp.data.domainmodel.DailyForecastSummary
import co.develhope.meteoapp.ui.adapter.homescreen.HomeScreenItems
import co.develhope.meteoapp.databinding.FragmentHomeScreenBinding
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val forecastSummaryList = Datasource.loadDataFromScreen()

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

        val nextDays: MutableList<HomeScreenItems.Forecast> = forecastSummaryList.map {
            HomeScreenItems.Forecast(it)
        }.toMutableList()

        listToShow.addAll(nextDays)
        listToShow.removeAt(3)
        return listToShow
    }
}