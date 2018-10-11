package com.example.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlindemo.decorator.DecoratorActivity
import com.example.kotlindemo.factory.FactoryActivity
import com.example.kotlindemo.proxy.ProxyActivity
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

        decorator.setOnClickListener {
            DecoratorActivity.start(this)
        }

        proxy.setOnClickListener {
            ProxyActivity.start(this)
        }

        factory.setOnClickListener {
            FactoryActivity.start(this)
        }
    }
}

