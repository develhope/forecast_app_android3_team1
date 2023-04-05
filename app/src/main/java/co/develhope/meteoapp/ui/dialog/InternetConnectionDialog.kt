package co.develhope.meteoapp.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.WindowManager.LayoutParams
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import co.develhope.meteoapp.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class InternetConnectionDialog (
    context : Context
) : DialogFragment() {

    private lateinit var retryButton : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.internet_dialog, container, false)
        retryButton = view.findViewById(R.id.retrybutton)
        setupListener()
        return view
    }

    override fun getTheme(): Int {
        return R.style.full_screen_dialog
    }

    private fun setupListener(){
        retryButton.setOnClickListener{
            this.dismiss()
            findNavController().navigate(R.id.homeFragment)

        }
    }




}