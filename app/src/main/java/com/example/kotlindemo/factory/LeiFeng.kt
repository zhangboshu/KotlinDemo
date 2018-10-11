package com.example.kotlindemo.factory

import android.util.Log

open class LeiFeng {

    val tag = "LeiFeng"

    fun sweep() {
        Log.i(tag, "扫地")
    }

    fun wash() {
        Log.i(tag, "洗衣服")
    }

    fun buyRice() {
        Log.i(tag, "买米")
    }
}

class Undergraduate : LeiFeng()

class Volunteer : LeiFeng()