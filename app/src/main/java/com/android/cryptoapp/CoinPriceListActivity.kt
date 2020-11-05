package com.android.cryptoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.cryptoapp.adapters.CoinInfoAdapter
import com.android.cryptoapp.adapters.onCoinClickListener
import com.android.cryptoapp.pojo.CoinPriceInfo
import kotlinx.android.synthetic.main.activity_coin_price_list.*


class CoinPriceListActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_price_list)

        val adapter = CoinInfoAdapter(this)
        adapter.onCoinClickListener = object : onCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
                val intent = CoinDetailActivity.newIntent(
                    this@CoinPriceListActivity,
                    coinPriceInfo.fromSymbol
                )
                startActivity(intent)
            }
        }
        recyclerviewCoinPriceList.adapter = adapter

        viewModel = ViewModelProviders.of(this)[CoinViewModel::class.java]
        viewModel.loadData()
        viewModel.priceList.observe(this, Observer {
            adapter.coinInfoList = it
        })
    }
}