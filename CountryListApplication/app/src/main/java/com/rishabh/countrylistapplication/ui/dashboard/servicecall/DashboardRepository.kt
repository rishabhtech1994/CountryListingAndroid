package com.rishabh.countrylistapplication.ui.dashboard.servicecall

import com.rishabh.countrylistapplication.api.ApiService
import com.rishabh.countrylistapplication.ui.dashboard.model.CountryListResponse
import io.reactivex.Observable

class DashboardRepository(private val apiService: ApiService) {
    fun callCountryListAPI(): Observable<ArrayList<CountryListResponse>> {
        return apiService.callCountryListApi()
    }

}