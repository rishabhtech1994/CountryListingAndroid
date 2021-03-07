package com.rishabh.countrylistapplication.ui.dashboard

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.rishabh.countrylistapplication.ui.base.BasePresenter
import com.rishabh.countrylistapplication.ui.base.BaseView
import com.rishabh.countrylistapplication.ui.dashboard.model.CountryListResponse

interface DashboardContract {

    interface View : BaseView<Presenter> {
        fun getContext(): AppCompatActivity ///to get activity context from presenter
        fun showHideProgressBar(status: Boolean)
        fun setAdapter(countryList: ArrayList<CountryListResponse>)

    }

    interface Presenter : BasePresenter {
        fun callCountryListAPI()
    }
}