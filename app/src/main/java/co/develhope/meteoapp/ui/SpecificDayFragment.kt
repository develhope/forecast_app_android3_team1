package co.develhope.meteoapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager

import co.develhope.meteoapp.data.domainmodel.*
import co.develhope.meteoapp.databinding.FragmentSpecificDayBinding
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.ui.adapter.specificday.SpecificDaayAdapter
import co.develhope.meteoapp.ui.adapter.specificday.SpecyfDayScreenItem

import kotlinx.coroutines.launch
import org.threeten.bp.OffsetDateTime



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
        getSpecificSummary()
    }

    private fun showForecastInSpecificDay(forecastSummaryList: List<SpecyficDayForecastSummary>) {
        val createdList = createSpecyfDayScreenItem(forecastSummaryList)

        val adapter = SpecificDaayAdapter(createdList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun createSpecyfDayScreenItem(forecastSummaryList: List<SpecyficDayForecastSummary>): List<SpecyfDayScreenItem> {
        val listShowItem = mutableListOf<SpecyfDayScreenItem>()

        listShowItem.add(SpecyfDayScreenItem.DetailsTitle(forecastSummaryList.first().title))
        listShowItem.add(SpecyfDayScreenItem.DetailsRow(forecastSummaryList.first()))
        listShowItem.add(SpecyfDayScreenItem.DetailsCard(forecastSummaryList.first().card))

        listShowItem.addAll(forecastSummaryList.map { SpecyfDayScreenItem.DetailsRow(it) })

        listShowItem.removeAt(3)

        return listShowItem
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    fun showRepos() {
        /*      Log.d("MainActivity", "list of repos received, size: ${repoResults.size}")

        val list = findViewById<RecyclerView>(R.id.repo_list)
        list.visibility = View.VISIBLE
        val adapter = RepoAdapter(repoResults)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)*/
    }


    private fun getSpecificSummary() {
        val dateTime = OffsetDateTime.now()
        lifecycleScope.launch {
            val result = NetworkProvider().getSpecificSummary(
                41.8955,
                12.4823,
                startDate = dateTime,
                endDate = dateTime
            )
            val forecastCard: List<CardForecast> = result.toDomainCard()
            val forecastRow: List<RowForecast> = result.toDomainRow()

//-------------------------------------------------------------------------------------
     /*       val cardForecastSummaryList: List<SpecyficDayForecastSummary> =
                forecastCard.mapIndexed { index, cardForecast ->
                    SpecyficDayForecastSummary(
                        card = CardForecast(
                            percepita = 0,
                            humidity = 0,
                            copertura = 0,
                            uv = 0,
                            vento = 0,
                            pioggia = 0
                        ),
                        row = RowForecast(
                            time = 0,
                            weatherCondition = this.weatherCondition.getOrNull(index),
                            humidity = 0,
                            temp = 0
                        ),
                        title = TitleForecast(
                            place = Place(
                                city = "Roma",
                                region = "Lazio",
                                lat = 41.8955,
                                log = 12.4823
                            ),
                            titleGiorno = "oggi",
                            titleData = this.titleData.getOrNull(index)
                        )
                    )
                }
            showForecastInSpecificDay(cardForecastSummaryList)

    */    }
    }
}











