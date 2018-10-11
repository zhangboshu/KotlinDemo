package com.example.kotlindemo.proxy

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlindemo.R
import kotlinx.android.synthetic.main.activity_decorator.*

class ProxyActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ProxyActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decorator)
        go.text = "开始代理"
        val proxy = Proxy("胖胖")
        go.setOnClickListener {
            proxy.giveDolls()
            proxy.giveFlowers()
            proxy.giveChocolate()
        }
    }
}
