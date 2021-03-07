package com.rishabh.countrylistapplication.ui.dashboard

import android.R.attr.data
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.rishabh.countrylistapplication.R
import com.rishabh.countrylistapplication.interfaces.OnCountryItemSelect
import com.rishabh.countrylistapplication.ui.base.BaseActivity
import com.rishabh.countrylistapplication.ui.countrydetails.CountryDetailsActivity
import com.rishabh.countrylistapplication.ui.dashboard.adapter.DashboardAdapter
import com.rishabh.countrylistapplication.ui.dashboard.model.CountryListResponse
import com.rishabh.countrylistapplication.ui.dashboard.servicecall.DashboardRepositoryProvider
import com.rishabh.countrylistapplication.utils.Constants
import com.rishabh.countrylistapplication.utils.Utils
import kotlinx.android.synthetic.main.activity_dashboard.*
import java.io.Serializable
import java.util.*


class DashboardActivity : BaseActivity(), DashboardContract.View, OnCountryItemSelect, SearchView.OnQueryTextListener {
    lateinit var dashboardPresenter: DashboardPresenter
    lateinit var countryAdapter: DashboardAdapter
    private var ascending = true
     var listCountry: ArrayList<CountryListResponse> = arrayListOf()
    override fun getLayout(): Int {
        return R.layout.activity_dashboard
    }

    override fun initResource() {
        dashboardPresenter = DashboardPresenter(this, DashboardRepositoryProvider.getDashboardRepository())
        setUpToolbar()
        searchViewCountry.setOnQueryTextListener(this)
        dashboardPresenter.callCountryListAPI()
    }

    private fun setUpToolbar() {
        toolbar.apply {
            toolbar.title = context.getString(R.string.country_list_app)
            setSupportActionBar(toolbar)
        }
    }

    override fun getContext(): AppCompatActivity {
        return this
    }

    override fun setAdapter(countryList: ArrayList<CountryListResponse>) {
        listCountry.addAll(countryList)
        adapterInit()
    }

    fun adapterInit(){
        countryAdapter = DashboardAdapter(this, listCountry, this)
        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewCountryList.apply {
            layoutManager = mLayoutManager
            itemAnimator = DefaultItemAnimator()
            adapter = countryAdapter
        }
    }

    override fun showHideProgressBar(status: Boolean) {
        if (status) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override fun goToNextPage() {
        TODO("Not yet implemented")
    }

    override fun isNetworkAvailable(): Boolean {
        return Utils.isConnectedToNetwork(this)
    }

    override fun showNetworkUnavailableMsg() {
        Utils.showToast(this, getString(R.string.checkNetwork))
    }

    override fun showSomeErrorOccurredMsg(msg: String) {
        Utils.showToast(this, msg)
    }


    // Serach
    override fun onQueryTextChange(newText: String?): Boolean {
        try {
            if (::countryAdapter.isInitialized) {
                if (!newText!!.isEmpty()) {
                    countryAdapter.filter(newText)
                } else if (newText.isEmpty()) {
                    countryAdapter.filter("")
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        return false
    }

    override fun onClickItem(countryListResponse: CountryListResponse) {
        val intent = Intent(this, CountryDetailsActivity::class.java)
        intent.putExtra(Constants.Keys.KEY_CLICKED_COUNTRY, countryListResponse)
        startActivity(intent)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.sortAZ -> {
                if(!ascending) {
                    listCountry.reverse()
                    clear()
                    adapterInit()
                    ascending = !ascending
                }
            }
            R.id.sortZA -> {
                if(ascending) {
                    listCountry.reverse()
                    clear()
                    adapterInit()
                    ascending = !ascending
                }
            }
        }
        return true
    }

    fun clear() {
        countryAdapter.notifyItemRangeRemoved(0, listCountry.size)
    }
}