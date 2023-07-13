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



        return CurrencyWidgetItemFactory(applicationContext, p0!!, repository)
    }


    class CurrencyWidgetItemFactory constructor(
        private var context: Context, intent: Intent,
        private var repository: Repository
    ) : RemoteViewsFactory {

        private var list:List<CurrencyEntity>? = null

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
            Log.d("OOO","onCreate")
            list = repository.getCurrency()
        }

        override fun onDataSetChanged() {
            Log.d("OOO","onDataSetChanged")
            if (list != null) {
                list = repository.getCurrency()
            }
        }

        override fun onDestroy() {
            Log.d("OOO","onDestroy")
        }

        override fun getCount(): Int {
            Log.d("OOO","getCount")
            var n = 0
            if(list != null){
                n = list!!.size
            }
            return n
        }

        override fun getViewAt(p0: Int): RemoteViews {
            Log.d("OOO","getViewAt")
            var views = RemoteViews(context.packageName, R.layout.currency_app_item_widget)
            if (list != null) {
                if (list!!.isNotEmpty()) {
                    views.setImageViewResource(R.id.img_flag, list!![p0].img)
                    views.setTextViewText(R.id.name_currency, list!![p0].name)
                    views.setTextViewText(R.id.name_currency_language, list!![p0].nameLanguage)
                    views.setTextViewText(
                        R.id.money_currency_purchase,
                        list!![p0].purchaseCurrency
                    )
                    views.setTextViewText(R.id.money_currency_sale, list!![p0].saleCurrency)
                }
            }

            return views
        }

        override fun getLoadingView(): RemoteViews {
            Log.d("OOO","getLoadingView")
            return RemoteViews(context.packageName, R.layout.currency_app_widget)
        }

        override fun getViewTypeCount(): Int {
            Log.d("OOO","getViewTypeCount")
            return 1
        }

        override fun getItemId(p0: Int): Long{
            Log.d("OOO","getItemId")
         return p0.toLong()
        }
        override fun hasStableIds(): Boolean {
            Log.d("OOO","hasStableIds")
         return true
        }

    }
}