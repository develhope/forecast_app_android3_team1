package co.develhope.meteoapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.HomeScreenAdapter
import co.develhope.meteoapp.adapter.HomeScreenItem
import co.develhope.meteoapp.data.DatasourceHomeScreen
import co.develhope.meteoapp.data.HourlyForecast
import co.develhope.meteoapp.databinding.FragmentHomeScreenBinding


class HomeFragment : Fragment(){
    private lateinit var bindingHomeScreen : FragmentHomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingHomeScreen = FragmentHomeScreenBinding.inflate(inflater,container,false )
        return bindingHomeScreen.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listHomeScreen = listToShow(DatasourceHomeScreen.loadData())
        val adapter = HomeScreenAdapter (listHomeScreen,listHomeScreen)
        bindingHomeScreen.recycleViewHomeScreen.adapter = adapter
        bindingHomeScreen.recycleViewHomeScreen.layoutManager = LinearLayoutManager(view.context)



    }

    private fun listToShow(hourlyForecast: List<HourlyForecast>): List<HomeScreenItem> {
        val list = mutableListOf<HomeScreenItem>()
        list.add(HomeScreenItem.Title)
        list.add(HomeScreenItem.ForecastDetail(hourlyForecast.first()))
        list.add(HomeScreenItem.Next5Days)
        val otherDays: MutableList<HomeScreenItem.ForecastDetail> = hourlyForecast.map {
            HomeScreenItem.ForecastDetail(it)
        }.toMutableList()
        list.addAll(otherDays)
        return list

    }
}