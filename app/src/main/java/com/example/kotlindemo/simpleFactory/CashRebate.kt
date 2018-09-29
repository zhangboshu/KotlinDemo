package com.example.kotlindemo.simpleFactory

//打折活动
class CashRebate constructor(private val moneyRebate: Double = 1.0) : CashSuper() {

    override fun acceptCash(money: Double): Double = money * moneyRebate
}