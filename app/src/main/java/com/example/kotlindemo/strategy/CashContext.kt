package com.example.kotlindemo.strategy

import com.example.kotlindemo.simpleFactory.CashNormal
import com.example.kotlindemo.simpleFactory.CashRebate
import com.example.kotlindemo.simpleFactory.CashReturn

/**
 * 策略模式得上下文, 策略模式主要是将所有算法抽离出来
 */
class CashContext constructor(val type: String) {

    var cs = when (type) {
        "打8折" -> CashRebate(0.8)
        "打5折" -> CashRebate(0.5)
        "打3折" -> CashRebate(0.3)
        "满50减8" -> CashReturn(50.0, 8.0)
        "满100减20" -> CashReturn(100.0, 20.0)
        else -> CashNormal()
    }

    fun getResult(money: Double) = cs.acceptCash(money)

}