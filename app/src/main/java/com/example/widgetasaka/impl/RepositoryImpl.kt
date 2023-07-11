package com.example.widgetasaka.impl

import android.content.Context
import android.util.Log
import com.example.widgetasaka.Repository
import com.example.widgetasaka.data.AppDatabase
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
        CoroutineScope(Dispatchers.IO).launch {
            database.currencyDao().insert(list)
            Log.d("SSS", "iiiinnnnssseeeeerrrrrttt ==== ${list.size}")
        }
    }

    override fun getCurrency(): List<CurrencyEntity> {
        var list = database.currencyDao().getAllCurrency()
        Log.d("SSS", "reeeeepppppooooooooo ==== ${list.size}")
        return list
    }

}