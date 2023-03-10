package co.develhope.meteoapp.ui.adapter.homescreen

import co.develhope.meteoapp.ui.adapter.homescreen.HomeScreenItems

interface OnClickCardItem {
    fun onCLickCard (cardDetail: HomeScreenItems.Forecast, position: Int){

    }
}