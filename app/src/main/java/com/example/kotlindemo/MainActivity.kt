package com.example.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_project.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_project)


        clickMe.setOnClickListener {
            println(Bean("ZhangBoshu", 20).toString())
            "zhangboshu".log("lll")
            log("lalala")
        }

    }
}


