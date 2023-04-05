package co.develhope.meteoapp.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import co.develhope.meteoapp.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class InternetConnectionDialog @Inject constructor(
    @ApplicationContext context : Context
) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.internet_dialog)
    }
}