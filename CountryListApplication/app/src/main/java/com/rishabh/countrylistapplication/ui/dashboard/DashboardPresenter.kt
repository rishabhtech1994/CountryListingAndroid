package com.rishabh.countrylistapplication.ui.dashboard

import android.content.Context
import android.os.Handler
import android.util.Base64
import android.util.Log
import com.google.gson.GsonBuilder
import com.rishabh.countrylistapplication.ui.base.BasePresenter
import com.rishabh.countrylistapplication.ui.dashboard.servicecall.DashboardRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class DashboardPresenter(
    private val view: DashboardContract.View,
    private val dashboardRepository: DashboardRepository
) : DashboardContract.Presenter {

    private var disposable: Disposable? = null
    val TAG="DashboardPresenter"
    override fun callCountryListAPI() {
        if (!view.isNetworkAvailable()) {
            view.showNetworkUnavailableMsg()
            return
        }
        view.showHideProgressBar(true)
        disposable = dashboardRepository.callCountryListAPI()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.showHideProgressBar(false)
                if(it.size > 0){
                    view.setAdapter(it)
                }
            }, {
                Log.e(TAG, it.toString())
                    view.showHideProgressBar(false)
                    if (view.isNetworkAvailable())
                        view.showSomeErrorOccurredMsg("Something went wrong")
                    else view.showNetworkUnavailableMsg()
            })
    }


}