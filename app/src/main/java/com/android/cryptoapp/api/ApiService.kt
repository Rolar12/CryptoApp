package com.android.cryptoapp.api

import com.android.cryptoapp.R
import com.android.cryptoapp.pojo.CoinInfoListOfData
import com.android.cryptoapp.pojo.CoinPriceInfoRawData
import com.android.cryptoapp.utils.Strings
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("top/totalvolfull")
    fun getTopCoinsInfo(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = Strings.get(R.string.api_key),
        @Query(QUERY_PARAM_LIMIT) limit: Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) toSymb: String = CURRENCY
    ): Single<CoinInfoListOfData>

    @GET("pricemultifull")
    fun getFullPriceList(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = Strings.get(R.string.api_key),
        @Query(QUERY_PARAM_FROM_SYMBOLS) fSymbs: String,
        @Query(QUERY_PARAM_TO_SYMBOLS) toSymbs: String = CURRENCY

    ): Single<CoinPriceInfoRawData>

    companion object {
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val QUERY_PARAM_FROM_SYMBOLS = "tsyms"
        private const val QUERY_PARAM_TO_SYMBOLS = "fsyms"

        private const val CURRENCY = "USD"
    }
}