package com.example.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlindemo.simpleFactory.SimpleFactoryActivity
import com.example.kotlindemo.strategy.StrategyActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        simpleFactory.setOnClickListener {
            SimpleFactoryActivity.start(this)
        }

        strategy.setOnClickListener {
            StrategyActivity.start(this)
        }
    }
}

