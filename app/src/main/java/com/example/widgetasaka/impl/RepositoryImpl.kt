package com.example.widgetasaka.impl

import android.content.Context
import android.util.Log
import com.example.widgetasaka.Repository
import com.example.widgetasaka.data.AppDatabase
import com.example.widgetasaka.data.CounterEntity
import com.example.widgetasaka.data.CurrencyDao
import com.example.widgetasaka.data.CurrencyEntity
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private var database: AppDatabase,
) : Repository {


    override fun insert(list: List<CurrencyEntity>) {
        database.currencyDao().insert(list)
    }

    override fun insertCounter(list: List<CounterEntity>) {
        database.counterDao().insert(list)
    }

    override fun getCurrency(): List<CurrencyEntity> {
        var list = database.currencyDao().getAllCurrency()
        Log.d("SSS", "reeeeepppppooooooooo ==== ${list.size}")
        return list
    }

    override fun getCounter(): List<CounterEntity> {
        return database.counterDao().getCounter()
    }

}