package com.example.widgetasaka

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.widgetasaka.data.CounterEntity
import com.example.widgetasaka.data.CurrencyEntity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BlankFragment : Fragment(R.layout.fragment_blank) {

    private val viewModel: ViewModel by viewModels<ViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.insert(
            arrayListOf(
                CurrencyEntity(
                    0,
                    R.drawable.united_states,
                    "USD",
                    "Доллар",
                    "11 510.00",
                    "11 610.00"
                ),
                CurrencyEntity(0, R.drawable.united, "EUR", "Евро", "11 800.00", "13 300.00"),
                CurrencyEntity(0, R.drawable.united_states, "RUB", "Рубль", "11 545.00", "130.00"),
                CurrencyEntity(0, R.drawable.united, "GBP", "Фунт", "14 400.00", "15 650.00"),
                CurrencyEntity(0, R.drawable.united_states, "JPY", "AAA", "70.00", "90.00")
            ), arrayListOf(CounterEntity(0,1)))
    }

}