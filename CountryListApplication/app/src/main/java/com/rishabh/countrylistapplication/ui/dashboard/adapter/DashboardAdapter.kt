package com.rishabh.countrylistapplication.ui.dashboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rishabh.countrylistapplication.R
import com.rishabh.countrylistapplication.interfaces.OnCountryItemSelect
import com.rishabh.countrylistapplication.ui.dashboard.model.CountryListResponse
import java.util.*
import kotlin.collections.ArrayList


class DashboardAdapter( private val context: Context,  private val countryList: ArrayList<CountryListResponse>,
                        private val countryItemSelect: OnCountryItemSelect
): RecyclerView.Adapter<DashboardAdapter.MyViewHolder>() {

    var countryListForAdap: ArrayList<CountryListResponse>
    lateinit var countryModel: CountryListResponse
    var listener: OnCountryItemSelect

    init {
        countryListForAdap = ArrayList()
        countryListForAdap.addAll(countryList)
        listener = countryItemSelect
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.getContext())
            .inflate(R.layout.country_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return countryList.size
    }



    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewCountryName: TextView
        init {
            textViewCountryName=itemView.findViewById(R.id.countryName)
        }
    }

    fun filter(charText: String) {
        var charText = charText
        charText = charText.toLowerCase(Locale.getDefault())
        countryListForAdap.clear()
        if (charText.length == 0) {
            countryListForAdap.addAll(countryList)
        } else {
            for (countryCodesModel in countryList) {
                if (countryCodesModel.name.toLowerCase(Locale.getDefault()).contains(charText)) {
                    countryListForAdap.add(countryCodesModel)
                }
            }
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        countryModel = countryList.get(position)
        if(countryListForAdap.size> 0) {
            (holder as MyViewHolder).textViewCountryName.text = countryModel.name

            holder.itemView.setOnClickListener {
                listener.onClickItem(countryModel)
            }
        }
    }


}


