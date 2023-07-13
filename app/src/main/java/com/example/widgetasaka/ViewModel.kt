package com.example.widgetasaka

import com.example.widgetasaka.data.CounterEntity
import com.example.widgetasaka.data.CurrencyEntity

interface ViewModel {

    fun insert(list:List<CurrencyEntity>,list1:List<CounterEntity>)
}