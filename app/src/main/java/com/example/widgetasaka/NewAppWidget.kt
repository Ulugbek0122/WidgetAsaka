package com.example.widgetasaka

import android.app.AlarmManager
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.util.Log
import android.widget.RemoteViews
import com.example.widgetasaka.data.CounterEntity


class NewAppWidget : AppWidgetProvider() {


    private var service: PendingIntent? = null

//    private var list: List<CounterEntity>? = null
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
//        if (repository != null){
//            list = repository!!.getCounter()
//        }

        for (appWidgetId in appWidgetIds) {
//            var reflashIntent = Intent(context, NewAppWidget::class.java)
//            reflashIntent.action = "aaaaaaa"
//            reflashIntent.putExtra("balanceWidgetId", appWidgetId)
//            Log.d("XXX", "onUpdate $appWidgetId")
//            var pendingIntent = PendingIntent.getBroadcast(
//                context,
//                0,
//                reflashIntent,
//                PendingIntent.FLAG_UPDATE_CURRENT
//            )

            var manager:AlarmManager =  context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            var i = Intent(context, BalanceService::class.java);

            if (service == null) {
                service = PendingIntent.getService(
                    context,
                    0,
                    i,
                    PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_IMMUTABLE
                );
            }
            manager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(), 60000, service);



//            var views = RemoteViews(context.packageName, R.layout.new_app_widget)
//            views.setOnClickPendingIntent(R.id.btn_reflesh_balance, pendingIntent)
//
//            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }


//    private fun updateWidgetBalance(
//        context: Context,
//        appWidgetManager: AppWidgetManager,
//        appWidgetIds: IntArray
//    ) {
//        for (appWidgetId in appWidgetIds) {
//            var views = RemoteViews(context.packageName, R.layout.new_app_widget).apply {
//
//            }
//        }
//    }

    override fun onReceive(context: Context?, intent: Intent?) {

//        var size = 0
//        if (list != null) {
//            size = list!!.size
//        }

        if ("aaaaaaa" == intent!!.action) {
            var appWidgetId = intent.getIntExtra("balanceWidgetId", 0)
            var views = RemoteViews(context!!.packageName, R.layout.new_app_widget)
//            views.setTextViewText(R.id.overall_balance, size.toString())
            Log.d("XXX", "onReceive = $appWidgetId")
            Log.d("XXX", "onReceive = $")
//            var appWidget = ComponentName(context,NewAppWidget::class.java)

            var appWidgetManager = AppWidgetManager.getInstance(context)
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
        super.onReceive(context, intent)
    }

//    override fun onAppWidgetOptionsChanged(
//        context: Context?,
//        appWidgetManager: AppWidgetManager?,
//        appWidgetId: Int,
//        newOptions: Bundle?
//    ) {
//        var views = RemoteViews(context!!.packageName, R.layout.new_app_widget)
//        resizeWidget(newOptions!!, views, context)
//
//        appWidgetManager!!.updateAppWidget(appWidgetId, views)
//    }
//
//
//    private fun resizeWidget(appWidgetOptions: Bundle, views: RemoteViews, context: Context) {
//
//        var minWidth = appWidgetOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH)
//        var maxWidth = appWidgetOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH)
//        var minHeight = appWidgetOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT)
//        var maxHeight = appWidgetOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT)
//
//        var str = "minWidth: $minWidth"
//        Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
//
//
//    }

//    private fun balance(){
//
//    }

}