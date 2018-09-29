package com.example.kotlindemo.strategy

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.kotlindemo.R
import com.example.kotlindemo.simpleFactory.CashAdapter
import kotlinx.android.synthetic.main.activity_simple_factory.*

class StrategyActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, StrategyActivity::class.java)
            context.startActivity(intent)
        }
    }

    var type: String = "正常价格"
    val arrayList: MutableList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_factory)

        val arr: Array<String> = arrayOf("正常价格", "打8折", "打5折", "打3折", "满50减8", "满100减20")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr)

        val recyclerAdapter = CashAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        spinner.adapter = adapter
        spinner.setSelection(0)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                type = spinner.getItemAtPosition(position).toString()
            }
        }

        ok.setOnClickListener {
            if (inputPrice.text.toString().isNotEmpty() && inputNum.text.toString().isNotEmpty()) {
                val cashSuper = CashContext(type) //策略模式
                val totalPrices = cashSuper.getResult(inputPrice.text.toString().toDouble() * inputNum.text.toString().toDouble())
                arrayList.add("单价: " + inputPrice.text.toString() + "  数量: " + inputNum.text.toString() +
                        "  $type" + "  合计: " + totalPrices.toString())
                recyclerAdapter.setData(arrayList)
                recyclerView.smoothScrollToPosition(recyclerAdapter.itemCount - 1)
                totalNum.text = totalPrices.toString()
            }
        }

        rest.setOnClickListener {
            inputPrice.setText("")
            inputNum.setText("")
        }
    }
}
