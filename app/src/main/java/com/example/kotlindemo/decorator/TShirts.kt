package com.example.kotlindemo.decorator

import android.util.Log

class TShirts : Finery() {
    override fun show() {
        Log.i("decorator", "大T恤")
        super.show()
    }
}

class BigTrouser : Finery() {
    override fun show() {
        Log.i("decorator", "裤子")
        super.show()

    }
}