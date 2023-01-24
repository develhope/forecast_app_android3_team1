package co.develhope.meteoapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.HomeScreenAdapter
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.DataItem.dioCunnuto
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
        super.onViewCreated(view, savedInstanceState)

        val adapterTitle = HomeScreenAdapter (0,dioCunnuto())
        bindingHomeScreen.recycleViewHomeScreen.adapter = adapterTitle
        bindingHomeScreen.recycleViewHomeScreen.layoutManager = LinearLayoutManager(view.context)

        val adapterCard = HomeScreenAdapter (1,dioCunnuto())
        bindingHomeScreen.recycleViewHomeScreen.adapter = adapterCard
        bindingHomeScreen.recycleViewHomeScreen.layoutManager = LinearLayoutManager(view.context)

        val adapterNextDays = HomeScreenAdapter (2,dioCunnuto())
        bindingHomeScreen.recycleViewHomeScreen.adapter = adapterNextDays
        bindingHomeScreen.recycleViewHomeScreen.layoutManager = LinearLayoutManager(view.context)





    }


}