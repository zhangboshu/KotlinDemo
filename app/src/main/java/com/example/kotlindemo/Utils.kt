package com.example.kotlindemo

import android.app.Activity
import android.util.Log

fun String.log(str: String) {
    Log.i(this, str)
}

fun Activity.log(str: String) {
    Log.i(this.toString(), str)
}


