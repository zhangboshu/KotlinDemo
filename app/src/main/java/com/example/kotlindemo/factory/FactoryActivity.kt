package com.example.kotlindemo.factory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlindemo.R
import kotlinx.android.synthetic.main.activity_decorator.*


/**
 * 工厂模式, 比简单工厂模式更加遵守了, 开放封闭原则, 对拓展开发, 对修改封闭
 */
class FactoryActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, FactoryActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decorator)

        go.text = "工厂模式, 学雷锋"
        go.setOnClickListener {
            val factory = UndergraduateFactory()
            val student = factory.createLeiFeng()

            student.buyRice()
            student.sweep()
            student.wash()
        }
    }
}
