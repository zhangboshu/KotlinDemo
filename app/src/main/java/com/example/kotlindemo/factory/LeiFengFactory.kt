package com.example.kotlindemo.factory

interface LeiFengFactory {

    fun createLeiFeng(): LeiFeng
}

class UndergraduateFactory() : LeiFengFactory {
    override fun createLeiFeng(): LeiFeng = Undergraduate()
}


class VolunteerFactory : LeiFengFactory {
    override fun createLeiFeng(): LeiFeng = Volunteer()
}

//如果有新的拓展, 可直接新增工厂方法即可