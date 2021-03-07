package com.rishabh.countrylistapplication.ui.countrydetails

import com.rishabh.countrylistapplication.R
import com.rishabh.countrylistapplication.ui.base.BaseActivity
import com.rishabh.countrylistapplication.ui.dashboard.model.CountryListResponse
import com.rishabh.countrylistapplication.utils.Constants
import kotlinx.android.synthetic.main.country_details_activity.*

class CountryDetailsActivity : BaseActivity() {
    lateinit var countryListResponse: CountryListResponse
    override fun getLayout(): Int {
        return R.layout.country_details_activity
    }

    override fun initResource() {
        countryListResponse =
            intent.getSerializableExtra(Constants.Keys.KEY_CLICKED_COUNTRY) as CountryListResponse
        setDataToUI()
    }

    private fun setDataToUI() {
        countryNameDetails.text = countryListResponse.name
        countryCapital.text = "Capital: "+countryListResponse.capital
        countryRegion.text = "Region: "+countryListResponse.region
        countryArea.text = "Area: "+countryListResponse.area.toString()
        countryPopulation.text = "Population: "+countryListResponse.population.toString()
    }
}