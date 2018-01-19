package com.example.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.button
import javax.security.auth.login.LoginException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ints = intArrayOf(1, 2, 3)

        ints.forEach {
            Log.i("wtf", it.toString())
        }

        var list = listOf(1, 2, 3)
        Log.i("wtf", "lastIndex: " + list.lastIndex)
        Log.i("wtf", "indices" + list.indices)

        for (i in list) {
            Log.i("wtf", i.toString())
        }

        for (i in list.indices){
            Log.i("wtf", i.toString())
        }

    }
}


