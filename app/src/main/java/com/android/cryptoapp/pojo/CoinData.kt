package com.android.cryptoapp.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinData(
    @SerializedName("CoinInfo")
    @Expose
    val coinInfo: CoinInfo? = null
)