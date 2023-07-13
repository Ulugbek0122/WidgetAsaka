package com.example.widgetasaka

import com.example.widgetasaka.data.CounterEntity
import com.example.widgetasaka.data.CurrencyEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelImpl @Inject constructor(
    private var repository: Repository
): ViewModel,androidx.lifecycle.ViewModel(){
    override fun insert(list: List<CurrencyEntity>,list1: List<CounterEntity>) {
        repository.insert(list)
        repository.insertCounter(list1)
    }


}