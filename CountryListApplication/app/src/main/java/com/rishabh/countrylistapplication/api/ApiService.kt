package com.rishabh.countrylistapplication.api

import com.rishabh.countrylistapplication.ui.dashboard.model.CountryListResponse
import com.rishabh.countrylistapplication.utils.EndPoints
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET(EndPoints.COUNTRY_LIST)
    fun callCountryListApi(): Observable<ArrayList<CountryListResponse>>
}