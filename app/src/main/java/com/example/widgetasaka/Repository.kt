package com.example.widgetasaka

import com.example.widgetasaka.data.CurrencyDao
import com.example.widgetasaka.data.CurrencyEntity

interface Repository {

    fun insert(list: List<CurrencyEntity>)

    fun getCurrency():List<CurrencyEntity>
}