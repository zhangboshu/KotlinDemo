package com.example.kotlindemo.proxy

/**
 * 代理
 * 调用真实的类的方法
 */
class Proxy constructor(val name: String) : IGiveGift {

    private val pursuit: Pursuit = Pursuit(name)

    override fun giveDolls() {
        pursuit.giveDolls()
    }

    override fun giveFlowers() {
        pursuit.giveFlowers()
    }

    override fun giveChocolate() {
        pursuit.giveChocolate()
    }
}