package com.example.kotlindemo.simpleFactory

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlindemo.R
import kotlinx.android.synthetic.main.item_cash_rv.view.*

class CashAdapter : RecyclerView.Adapter<CashAdapter.ViewHolder>() {

    private var data: List<String> = arrayListOf()

    fun setData(data: List<String>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        val view = inflater.inflate(R.layout.item_cash_rv, null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int =
            data.size


    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.itemView.tv.text = data[p1]
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}