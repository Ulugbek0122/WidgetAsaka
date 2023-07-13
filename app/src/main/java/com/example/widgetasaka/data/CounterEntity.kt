package com.example.widgetasaka.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "counter")
data class CounterEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var counter:Int
)
