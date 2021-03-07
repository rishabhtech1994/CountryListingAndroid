package com.rishabh.countrylistapplication.interfaces

import android.widget.AdapterView
import com.rishabh.countrylistapplication.ui.dashboard.model.CountryListResponse

interface OnCountryItemSelect {

    fun onClickItem(countryListResponse: CountryListResponse)
}