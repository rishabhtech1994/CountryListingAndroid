package com.rishabh.countrylistapplication.ui.dashboard.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RegionalBloc(

    @SerializedName("acronym")
    @Expose
    val acronym: String,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("otherAcronyms")
    @Expose
    val otherAcronyms: List<String>,
    @SerializedName("otherNames")
    @Expose
    val otherNames: List<String>
): Serializable