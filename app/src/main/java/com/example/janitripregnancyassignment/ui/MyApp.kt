package com.example.janitripregnancyassignment.ui

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.work.WorkManager

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel(this)

        WorkManager.getInstance(this).getWorkInfosByTagLiveData("vitals_notification")
        .observeForever { workInfos ->
            workInfos.forEach {
                Log.d("WorkManager", "Status: ${it.state}")
            }
        }
    }

    private fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "vitals_channel", // Unique ID
                "Vitals Tracker Notifications", // Name for UI
                NotificationManager.IMPORTANCE_HIGH // Importance level
            ).apply {
                description = "Reminder to log vitals"
            }

            val notificationManager =
                context.getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(channel)
        }
    }
}