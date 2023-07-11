package com.example.widgetasaka

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import javax.inject.Inject

class CurrencyWidgetService: RemoteViewsService() {

    @Inject
    lateinit var repository:Repository

    override fun onGetViewFactory(p0: Intent?): RemoteViewsFactory {
       return CurrencyWidgetItemFactory(applicationContext,p0!!,repository)
    }


    class CurrencyWidgetItemFactory constructor(private var context: Context,intent: Intent, repository: Repository) :RemoteViewsFactory{

        private var list = repository.getCurrency()

        private var appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,AppWidgetManager.INVALID_APPWIDGET_ID)
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

            return list.size
        }

        override fun getViewAt(p0: Int): RemoteViews {
            var views = RemoteViews(context.packageName,R.layout.currency_app_item_widget)
            views.setImageViewResource(R.id.img_flag, list[p0].img)
            views.setTextViewText(R.id.name_currency,list[p0].name)
            views.setTextViewText(R.id.name_currency_language,list[p0].nameLanguage)
            views.setTextViewText(R.id.money_currency_purchase,list[p0].purchaseCurrency)
            views.setTextViewText(R.id.money_currency_sale,list[p0].saleCurrency)
            return views
        }

        override fun getLoadingView(): RemoteViews {
           return RemoteViews(context.packageName,R.layout.currency_app_item_widget)
        }

        override fun getViewTypeCount(): Int {
            return 1
        }

        override fun getItemId(p0: Int): Long  = p0.toLong()

        override fun hasStableIds(): Boolean  = true

    }
}