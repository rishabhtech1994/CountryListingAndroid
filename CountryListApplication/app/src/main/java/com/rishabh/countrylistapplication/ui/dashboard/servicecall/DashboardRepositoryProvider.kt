package com.rishabh.countrylistapplication.ui.dashboard.servicecall

import com.rishabh.countrylistapplication.api.ApiService
import com.rishabh.countrylistapplication.api.RetrofitClient

object DashboardRepositoryProvider {
    fun getDashboardRepository(): DashboardRepository {
        return DashboardRepository(RetrofitClient.getClient()!!.create(ApiService::class.java))
    }
}