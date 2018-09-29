package com.example.kotlindemo.simpleFactory

class CashNormal : CashSuper() {
    override fun acceptCash(money: Double): Double {
        return money
    }
}