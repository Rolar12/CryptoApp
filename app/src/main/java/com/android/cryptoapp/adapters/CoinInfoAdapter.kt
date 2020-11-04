package com.android.cryptoapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.cryptoapp.R
import com.android.cryptoapp.pojo.CoinPriceInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_coin_info.view.*

class CoinInfoAdapter(private val context: Context) :
    RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {

    var coinInfoList: List<CoinPriceInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onCoinClickListener: onCoinClickListener? = null

    inner class CoinInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewLogoCoin = itemView.imageView_logo_coin
        val textViewSymbols = itemView.textViewSymbols
        val textViewPrice = itemView.textViewPrice
        val textViewLastUpdate = itemView.textViewLastUpdate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_coin_info, parent, false)
        return CoinInfoViewHolder(view)
    }

    override fun getItemCount() = coinInfoList.size

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = coinInfoList[position]
        with(holder) {
            with(coin) {
                val symbolsPairTemplate = context.resources.getString(R.string.symbols_pair)
                val lastUpdateTimeTemplate = context.resources.getString(R.string.last_update_time)
                textViewSymbols.text = String.format(symbolsPairTemplate, fromSymbol, toSymbol)
                textViewPrice.text = price
                textViewLastUpdate.text = String.format(lastUpdateTimeTemplate, getFormattedTime())
                Picasso.get().load(getFullImageUrl()).into(holder.imageViewLogoCoin)
                itemView.setOnClickListener {
                    onCoinClickListener?.onCoinClick(this)
                }
            }
        }
    }
}

interface onCoinClickListener {
    fun onCoinClick(coinPriceInfo: CoinPriceInfo)
}