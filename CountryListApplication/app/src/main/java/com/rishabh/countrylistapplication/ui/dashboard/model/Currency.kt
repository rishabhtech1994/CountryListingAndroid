package com.rishabh.countrylistapplication.ui.dashboard.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Currency(
    @SerializedName("code")
    @Expose
    val code: String,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("symbol")
    @Expose
    val symbol: String
) :Serializable{
}