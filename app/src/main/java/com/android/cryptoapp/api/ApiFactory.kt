package com.android.cryptoapp.api

import com.android.cryptoapp.R
import com.android.cryptoapp.utils.Strings
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private val BASE_URL = Strings.get(R.string.base_url)

    private val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).baseUrl(
            BASE_URL
        ).build()

    val apiService = retrofit.create(ApiService::class.java)
}