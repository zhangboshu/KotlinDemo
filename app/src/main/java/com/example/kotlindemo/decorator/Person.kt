package com.example.kotlindemo.decorator

import android.util.Log

/**
 * 装饰模式
 * ConcreteComponent
 */
open class Person {

    private lateinit var name: String

    constructor()

    constructor(name: String) {
        this.name = name
    }

    open fun show() {
        Log.i("decorator", "装扮的$name")
    }
}