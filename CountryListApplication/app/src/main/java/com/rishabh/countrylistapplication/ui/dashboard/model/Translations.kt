package com.rishabh.countrylistapplication.ui.dashboard.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Translations(

    @SerializedName("de")
    @Expose
    val de: String,
    @SerializedName("es")
    @Expose
    val es: String,
    @SerializedName("fr")
    @Expose
    val fr: String,
    @SerializedName("ja")
    @Expose
    val ja: String,
    @SerializedName("it")
    @Expose
    val it: String,
    @SerializedName("br")
    @Expose
    val br: String,
    @SerializedName("nl")
    @Expose
    val nl: String,
    @SerializedName("hr")
    @Expose
    val hr: String,
    @SerializedName("fa")
    @Expose
    val fa: String
) : Serializable