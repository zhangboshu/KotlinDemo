package com.example.kotlindemo.simpleFactory

//满减活动
class CashReturn constructor(private val moneyCondition: Double = 0.0,
                             private val moneyReturn: Double = 0.0) : CashSuper() {

    override fun acceptCash(money: Double): Double {
        var result = money

        if (money >= moneyCondition)
            result = money - Math.floor(money / moneyCondition) * moneyReturn

        return result
    }
}