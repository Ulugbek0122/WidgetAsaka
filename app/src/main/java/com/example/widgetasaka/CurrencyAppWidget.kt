package com.example.widgetasaka

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.RemoteViews


class CurrencyAppWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {

        for (appWidgetId in appWidgetIds) {

            var reflashIntent = Intent(context,CurrencyAppWidget::class.java)
            reflashIntent.action = "actionToast"
            reflashIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,appWidgetId)
            Log.d("VVV","appWidgetId = $appWidgetId")
            var buttonReflash = PendingIntent.getBroadcast(
                context,
                0,
                reflashIntent,
                PendingIntent.FLAG_IMMUTABLE
            )

            var serviceIntent = Intent(context,CurrencyWidgetService::class.java)
            serviceIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,appWidgetId)
            serviceIntent.data = Uri.parse(serviceIntent.toUri(Intent.URI_INTENT_SCHEME))

            var views = RemoteViews(context.packageName,R.layout.currency_app_widget)
            views.setRemoteAdapter(R.id.list_currency,serviceIntent)
            views.setOnClickPendingIntent(R.id.reflash,buttonReflash)

            var appWidgetOptions = appWidgetManager.getAppWidgetOptions(appWidgetId)
            resizeWidget(appWidgetOptions,views)

            appWidgetManager.updateAppWidget(appWidgetId,views)
            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId,R.id.list_currency)
        }
    }

    override fun onAppWidgetOptionsChanged(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetId: Int,
        newOptions: Bundle?
    ) {
        var views = RemoteViews(context!!.packageName,R.layout.currency_app_widget)
        resizeWidget(newOptions!!,views)
        appWidgetManager!!.updateAppWidget(appWidgetId,views)
    }

    private fun resizeWidget(appWidgetOptions:Bundle,views:RemoteViews){

        var minWidth = appWidgetOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH)
        var maxWidth = appWidgetOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH)
        var minHeight = appWidgetOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT)
        var maxHeight = appWidgetOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT)
    }


    override fun onReceive(context: Context?, intent: Intent?) {
        if ("actionToast" == intent!!.action){
            val appWidgetId = intent.getIntExtra(
                AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID
            )

            Log.d("VVV","appWidgetId onReceive = $appWidgetId")
            var appWidgetManager = AppWidgetManager.getInstance(context)
            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId,R.id.list_currency)
        }
        super.onReceive(context, intent)
    }


}