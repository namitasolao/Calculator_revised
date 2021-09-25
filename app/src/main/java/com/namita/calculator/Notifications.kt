package com.namita.calculator

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE

const val CHANNEL_ID = "defaultNotifications"

var notificationCount = 0

fun createNotificationChannel(context: Context) {
    val name = context.getString(R.string.channel_name)
    val descriptionText = context.getString(R.string.channel_name)
    val importance = NotificationManager.IMPORTANCE_DEFAULT
    val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
    mChannel.description = descriptionText
    // Register the channel with the system; you can't change the importance
    // or other notification behaviors after this
    val notificationManager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.createNotificationChannel(mChannel)
}