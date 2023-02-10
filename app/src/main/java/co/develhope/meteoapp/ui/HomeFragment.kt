package co.develhope.meteoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.HomeScreenAdapter
import co.develhope.meteoapp.data.DailyForecastSummary
import co.develhope.meteoapp.data.Datasource
import co.develhope.meteoapp.data.HomeScreenItems
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

        val forecastSummaryList = Datasource.loadData()

        val listCreated = createHomeScreenItems(forecastSummaryList)

        val adapter = HomeScreenAdapter(listCreated)
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
        return listToShow
    }
}