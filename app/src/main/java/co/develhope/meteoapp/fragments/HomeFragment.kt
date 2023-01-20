package co.develhope.meteoapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.FragmentHomeScreenBinding


class HomeFragment : Fragment(){
    private var bindingHomeScreen : FragmentHomeScreenBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingHomeScreen = FragmentHomeScreenBinding.inflate(inflater,container,false )
        return inflater.inflate(R.layout.card_home_screen, container, false)
    }


}