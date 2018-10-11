package com.example.kotlindemo.proxy

import android.util.Log

/**
 * 代理模式
 * 真实的类
 */
class Pursuit constructor(val name: String) : IGiveGift {


    override fun giveDolls() {
        Log.i("proxy", "$name 送你洋娃娃")
    }

    override fun giveFlowers() {
        Log.i("proxy", "$name 送你鲜花")
    }

    override fun giveChocolate() {
        Log.i("proxy", "$name 送你巧克力")
    }
}