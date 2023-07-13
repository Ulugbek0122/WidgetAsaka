package com.example.widgetasaka

import com.example.widgetasaka.data.CounterDao
import com.example.widgetasaka.data.CounterEntity
import com.example.widgetasaka.data.CurrencyDao
import com.example.widgetasaka.data.CurrencyEntity

interface Repository {

    fun insert(list: List<CurrencyEntity>)

    fun insertCounter(list: List<CounterEntity>)

    fun getCurrency():List<CurrencyEntity>

    fun getCounter():List<CounterEntity>
}