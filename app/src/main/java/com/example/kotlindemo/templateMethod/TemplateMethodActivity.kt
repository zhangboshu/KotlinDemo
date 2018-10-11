package com.example.kotlindemo.templateMethod

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class TemplateMethodActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, TemplateMethodActivity::class.java))
        }
    }

    lateinit var c: AbstractClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        c = ConcreteClassA()
        c.templateMethod()

        c = ConcreteClassB()
        c.templateMethod()

    }
}
