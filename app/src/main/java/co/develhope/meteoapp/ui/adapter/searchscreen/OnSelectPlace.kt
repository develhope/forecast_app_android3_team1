package co.develhope.meteoapp.ui.adapter.searchscreen

import co.develhope.meteoapp.data.domainmodel.Place

interface OnSelectPlace  {

    fun selectPlace(place : Place)
}