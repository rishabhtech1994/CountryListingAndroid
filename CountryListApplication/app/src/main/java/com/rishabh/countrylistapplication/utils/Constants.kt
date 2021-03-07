package com.rishabh.countrylistapplication.utils

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object Constants {

    object Services{
        val BASE_URL="https://restcountries.eu/"
    }

    object Keys{
        val KEY_CLICKED_COUNTRY="KEY_CLICKED_COUNTRY"
    }


    fun setTimeOut(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient().newBuilder()
            .connectTimeout(100 * 10, TimeUnit.SECONDS)
            .readTimeout(100 * 10, TimeUnit.SECONDS)
            .writeTimeout(100 * 10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor { chain ->
                val request = chain.request()
                    ?.newBuilder()
                    ?.addHeader("Content-Type", "application/json")
                    ?.build()
                chain.proceed(request)
            }
            .addInterceptor(loggingInterceptor)
            .build()
    }
}