package co.develhope.meteoapp.ui

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        //creo un riferimento al nav controller
        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHost.navController

        //creo un riferimento al widget per la bottom navigation
        val bottomNavigation : BottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigation.setupWithNavController(navController)

        bottomNavigation.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
               when(item.itemId){
                   R.id.homeFragment -> {
                       if(findNavController(R.id.nav_host_fragment_container).currentDestination?.label!!.equals("fragment_specific_day")){
                           findNavController(R.id.nav_host_fragment_container).navigate(R.id.action_specificDayFragment_to_homeFragment)
                       }else if(findNavController(R.id.nav_host_fragment_container).currentDestination?.label!!.equals("TomorrowFragment")){
                           findNavController(R.id.nav_host_fragment_container).navigate(R.id.action_tomorrowFragment_to_homeFragment)
                       }else if(findNavController(R.id.nav_host_fragment_container).currentDestination?.label!!.equals("fragment_search")){
                           findNavController(R.id.nav_host_fragment_container).navigate(R.id.action_searchFragment_to_homeFragment)
                       }
                       return true
                   }
                   R.id.specificDayFragment -> {
                       if(findNavController(R.id.nav_host_fragment_container).currentDestination?.label!!.equals("fragment_home")){
                           findNavController(R.id.nav_host_fragment_container).navigate(R.id.action_homeFragment_to_specificDayFragment)
                       }else if(findNavController(R.id.nav_host_fragment_container).currentDestination?.label!!.equals("TomorrowFragment")){
                           findNavController(R.id.nav_host_fragment_container).navigate(R.id.action_tomorrowFragment_to_specificDayFragment)
                       }else if(findNavController(R.id.nav_host_fragment_container).currentDestination?.label!!.equals("fragment_search")){
                           findNavController(R.id.nav_host_fragment_container).navigate(R.id.action_searchFragment_to_specificDayFragment)
                       }
                       return true
                   }
                   R.id.tomorrowFragment -> {
                       Log.d("Current Destination" , "${findNavController(R.id.nav_host_fragment_container).currentDestination?.label}")
                       if(findNavController(R.id.nav_host_fragment_container).currentDestination?.label!!.equals("fragment_home")){
                           findNavController(R.id.nav_host_fragment_container).navigate(R.id.action_homeFragment_to_tomorrowFragment)
                       }else if(findNavController(R.id.nav_host_fragment_container).currentDestination?.label!!.equals("fragment_specific_day")){
                           findNavController(R.id.nav_host_fragment_container).navigate(R.id.action_specificDayFragment_to_tomorrowFragment)
                       }else if(findNavController(R.id.nav_host_fragment_container).currentDestination?.label!!.equals("fragment_search")){
                           findNavController(R.id.nav_host_fragment_container).navigate(R.id.action_searchFragment_to_tomorrowFragment)
                       }
                       return true
                   }
                   R.id.searchFragment -> {
                       Log.d("Current Destination" , "${findNavController(R.id.nav_host_fragment_container).currentDestination?.label}")
                       if(findNavController(R.id.nav_host_fragment_container).currentDestination?.label!!.equals("fragment_home")){
                           findNavController(R.id.nav_host_fragment_container).navigate(R.id.action_homeFragment_to_searchFragment)
                       }else if(findNavController(R.id.nav_host_fragment_container).currentDestination?.label!!.equals("fragment_specific_day")){
                           findNavController(R.id.nav_host_fragment_container).navigate(R.id.action_specificDayFragment_to_searchFragment)
                       }else if(findNavController(R.id.nav_host_fragment_container).currentDestination?.label!!.equals("TomorrowFragment")){
                           findNavController(R.id.nav_host_fragment_container).navigate(R.id.action_tomorrowFragment_to_searchFragment)
                       }

                       return true
                   }
                   else -> return true
               }
            }

        })
    }


}