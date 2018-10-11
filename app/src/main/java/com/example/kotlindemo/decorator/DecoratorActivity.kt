package com.example.kotlindemo.decorator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlindemo.R
import kotlinx.android.synthetic.main.activity_decorator.*

class DecoratorActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, DecoratorActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decorator)

        val person = Person("胖子")
        val bigTrouser = BigTrouser()
        val tShirts = TShirts()

        bigTrouser.decorate(person)
        tShirts.decorate(bigTrouser)

        go.setOnClickListener {
            tShirts.show()
        }
    }
}
