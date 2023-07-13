package com.example.widgetasaka

import android.app.Service
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Intent
import android.os.IBinder
import android.widget.RemoteViews
import java.util.Random


class BalanceService:Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val random = Random()
        val randomInt = random.nextInt(100)
        val lastUpdate = "R: $randomInt"
        // Reaches the view on widget and displays the number
        // Reaches the view on widget and displays the number
        val view = RemoteViews(packageName, R.layout.new_app_widget)
        view.setTextViewText(R.id.overall_balance, lastUpdate)
        val theWidget = ComponentName(this, NewAppWidget::class.java)
        val manager = AppWidgetManager.getInstance(this)
        manager.updateAppWidget(theWidget, view)
        return super.onStartCommand(intent, flags, startId)
    }
}