package com.rishabh.countrylistapplication.ui.dashboard.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CountryListResponse (
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("topLevelDomain")
    @Expose
    var topLevelDomain: List<String>,
    @SerializedName("alpha2Code")
    @Expose
    val alpha2Code: String,
    @SerializedName("alpha3Code")
    @Expose
    val alpha3Code: String,
    @SerializedName("callingCodes")
    @Expose
    val callingCodes: List<String>,
    @SerializedName("capital")
    @Expose
    val capital: String,
    @SerializedName("altSpellings")
    @Expose
    val altSpellings: List<String>,
    @SerializedName("region")
    @Expose
    val region: String,
    @SerializedName("population")
    @Expose
    val population: Int,
    @SerializedName("latlng")
    @Expose
    val latlng: List<Double>,
    @SerializedName("demonym")
    @Expose
    val demonym: String,
    @SerializedName("area")
    @Expose
    val area: Double,
    @SerializedName("gini")
    @Expose
    val gini: Double,
    @SerializedName("timezones")
    @Expose
    val timezones: List<String>,
    @SerializedName("borders")
    @Expose
    val borders: List<String>,
    @SerializedName("nativeName")
    @Expose
    val nativeName: String,
    @SerializedName("numericCode")
    @Expose
    val numericCode: String,
    @SerializedName("currencies")
    @Expose
    val currencies: List<Currency>,
    @SerializedName("languages")
    @Expose
    val languages: List<Language>,
    @SerializedName("translations")
    @Expose
    val translations: Translations,
    @SerializedName("flag")
    @Expose
    val flag: String,
    @SerializedName("regionalBlocs")
    @Expose
    val regionalBlocs:List<RegionalBloc>,
    @SerializedName("cioc")
    @Expose
    val cioc: String
): Serializable{


}