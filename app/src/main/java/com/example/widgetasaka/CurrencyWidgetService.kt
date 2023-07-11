package com.example.widgetasaka

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.example.widgetasaka.data.CurrencyEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CurrencyWidgetService : RemoteViewsService() {

    @Inject
    lateinit var repository: Repository

    override fun onGetViewFactory(p0: Intent?): RemoteViewsFactory {


        var currency = repository.getCurrency()
        Log.d("SSS", "aaaaaaa ==== ${currency.size}")
        return CurrencyWidgetItemFactory(applicationContext, p0!!, currency)
    }


    class CurrencyWidgetItemFactory constructor(
        private var context: Context, intent: Intent,
        private var currency: List<CurrencyEntity>
    ) : RemoteViewsFactory {


        private var appWidgetId = intent.getIntExtra(
            AppWidgetManager.EXTRA_APPWIDGET_ID,
            AppWidgetManager.INVALID_APPWIDGET_ID
        )
//        private var list:List<CurrencyData> = arrayListOf(
//            CurrencyData( R.drawable.united_states,"USD","Доллар","11 510.00","11 610.00"),
//            CurrencyData( R.drawable.united,"EUR","Евро","11 800.00","13 300.00"),
//            CurrencyData( R.drawable.united_states,"RUB","Рубль","11 545.00","130.00"),
//            CurrencyData( R.drawable.united,"GBP","Фунт","14 400.00","15 650.00"),
//            CurrencyData( R.drawable.united_states,"JPY","AAA","70.00","90.00"))

        override fun onCreate() {

        }

        override fun onDataSetChanged() {

        }

        override fun onDestroy() {

        }

        override fun getCount(): Int {

            return currency.size
        }

        override fun getViewAt(p0: Int): RemoteViews {

            var views = RemoteViews(context.packageName, R.layout.currency_app_item_widget)
            if (currency.isNotEmpty()) {
                views.setImageViewResource(R.id.img_flag, currency[p0].img)
                views.setTextViewText(R.id.name_currency, currency[p0].name)
                views.setTextViewText(R.id.name_currency_language, currency[p0].nameLanguage)
                views.setTextViewText(R.id.money_currency_purchase, currency[p0].purchaseCurrency)
                views.setTextViewText(R.id.money_currency_sale, currency[p0].saleCurrency)
            }
            return views
        }

        override fun getLoadingView(): RemoteViews {
            return RemoteViews(context.packageName, R.layout.currency_app_item_widget)
        }

        override fun getViewTypeCount(): Int {
            return 1
        }

        override fun getItemId(p0: Int): Long = p0.toLong()

        override fun hasStableIds(): Boolean = true

    }
}