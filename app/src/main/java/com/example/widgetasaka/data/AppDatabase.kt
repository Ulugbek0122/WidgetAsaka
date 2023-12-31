package com.example.widgetasaka.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CurrencyEntity::class,CounterEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase() {

    abstract fun currencyDao():CurrencyDao
    abstract fun counterDao():CounterDao
}