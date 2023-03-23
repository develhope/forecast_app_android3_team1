package co.develhope.meteoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.MeteoApp
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Datasource

import co.develhope.meteoapp.data.domainmodel.*
import co.develhope.meteoapp.databinding.FragmentSpecificDayBinding
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.network.dto.SpecificSummary
import co.develhope.meteoapp.ui.adapter.specificday.SpecificDaayAdapter
import co.develhope.meteoapp.ui.adapter.specificday.SpecyfDayScreenItem
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.threeten.bp.OffsetDateTime



class SpecificDayFragment : Fragment() {


    private var _binding: FragmentSpecificDayBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpecificDayBinding.inflate(inflater, container, false)

        super.onStart()
        if(MeteoApp.preferences?.getCurrentPlace() == null){
            findNavController().navigate(R.id.action_specificDayFragment_to_searchFragment)
        }else{
            getSpecificSummary()
        }

        val view = binding.root
        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    private fun showForecastInSpecificDay(forecastSummaryList: List<SpecyficDayForecastSummary>) {
        val createdList = createSpecyfDayScreenItem(forecastSummaryList)

        val adapter = SpecificDaayAdapter(createdList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun getTime(): OffsetDateTime = OffsetDateTime.now()

    private fun createSpecyfDayScreenItem(forecastSummaryList: List<SpecyficDayForecastSummary>): List<SpecyfDayScreenItem> {
        val listShowItem = mutableListOf<SpecyfDayScreenItem>()

        val filterLists =
            forecastSummaryList.filter{ specyficDayForecastSummary -> specyficDayForecastSummary.row.time.isAfter(getTime())  }

        listShowItem.add(SpecyfDayScreenItem.DetailsTitle(getTitleForecast()))
        listShowItem.add(SpecyfDayScreenItem.DetailsRow(filterLists.first()))
        listShowItem.add(SpecyfDayScreenItem.DetailsCard(filterLists.first().card))

        listShowItem.addAll(filterLists.map { SpecyfDayScreenItem.DetailsRow(it) })
        listShowItem.removeAt(3)

        return listShowItem
    }

    private fun getTitleForecast() : TitleForecast{
     return   TitleForecast(
            place = getPlace()!!,
            date = getSelectedDate()
        )
    }

    private fun getPlace() : Place? {
        return MeteoApp.preferences?.getCurrentPlace()
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun getSpecificSummary() {
        val dateTime = getSelectedDate()
        lifecycleScope.launch(Dispatchers.IO) {
            val result = NetworkProvider().getSpecificSummary(
                getPlace()!!.lat,
                getPlace()!!.log,
                startDate = dateTime,
                endDate = dateTime
            )
            val hourlyForecast: List<SpecyficDayForecastSummary> = result.toDomain()

            withContext(Dispatchers.Main) {
                showForecastInSpecificDay(hourlyForecast)
            }
        }
    }

    private fun getSelectedDate() = OffsetDateTime.now()
}

//-------------------------------------------------------------------------------------


      /*      val cardForecastSummaryList: List<SpecyficDayForecastSummary> =
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
                            weatherCondition = WeatherCondition.RAIN,
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
                            titleData = dateTime
                        )
                    )
                }
            showForecastInSpecificDay(cardForecastSummaryList)

       }
    }
}
*/