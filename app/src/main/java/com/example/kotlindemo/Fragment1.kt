package com.example.kotlindemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

@SuppressLint("ValidFragment")
/**
 * Created by zhangboshu on 27/01/18.
 */
class Fragment1 public constructor(val string: String) : Fragment() {

    lateinit var textView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val inflate = inflater.inflate(R.layout.activity_main, container, false)

        textView = inflate.findViewById<TextView>(R.id.frag_tv)
        textView.text = string

        return inflate
    }

    companion object {
        fun newInstance(string: String) = Fragment1(string)
    }
}