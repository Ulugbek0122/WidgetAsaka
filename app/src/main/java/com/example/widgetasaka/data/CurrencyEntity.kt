package com.example.widgetasaka.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency")
data class CurrencyEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var img:Int,
    var name:String,
    var nameLanguage:String,
    var purchaseCurrency:String,
    var saleCurrency:String
)
