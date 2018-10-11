package com.example.kotlindemo.templateMethod

import android.util.Log

class ConcreteClassA : AbstractClass() {

    override fun primitiveOperation1() {
        Log.i("TemplateMethod", "具体类A 方法1 实现")
    }

    override fun primitiveOperation2() {
        Log.i("TemplateMethod", "具体类A 方法2 实现")
    }
}

class ConcreteClassB : AbstractClass() {
    override fun primitiveOperation1() {
        Log.i("TemplateMethod", "具体类B 方法1 实现")
    }

    override fun primitiveOperation2() {
        Log.i("TemplateMethod", "具体类B 方法2 实现")
    }

}