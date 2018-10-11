package com.example.kotlindemo.templateMethod

import android.util.Log

abstract class AbstractClass {

    //一些抽象方法, 让子类去实现
    abstract fun primitiveOperation1()

    abstract fun primitiveOperation2()

    //模板方法, 给出逻辑骨架,操作等, 让他们推迟到子类去实现
    fun templateMethod() {
        primitiveOperation1()
        primitiveOperation2()
        Log.i("TemplateMethod", "")
    }
}