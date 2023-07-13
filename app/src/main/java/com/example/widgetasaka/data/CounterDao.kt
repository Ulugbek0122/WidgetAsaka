package com.example.widgetasaka.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CounterDao {

    @Insert
    fun insert(counterEntity: List<CounterEntity>)

    @Query("SELECT * FROM counter")
    fun getCounter():List<CounterEntity>
}