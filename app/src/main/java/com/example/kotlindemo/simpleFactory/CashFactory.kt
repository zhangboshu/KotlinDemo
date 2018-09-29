package com.example.kotlindemo.simpleFactory

//简单的工厂模式, 利用多态, 将父类暴露出来
object CashFactory {

    fun createCashAccept(type: String): CashSuper = when (type) {
        "打8折" -> CashRebate(0.8)
        "打5折" -> CashRebate(0.5)
        "打3折" -> CashRebate(0.3)
        "满50减8" -> CashReturn(50.0, 8.0)
        "满100减20" -> CashReturn(100.0, 20.0)
        else -> CashNormal()
    }

}