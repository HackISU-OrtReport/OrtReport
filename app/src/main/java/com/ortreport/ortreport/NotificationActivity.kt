package com.ortreport.ortreport

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.support.v4.app.NotificationCompat

class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
    }
    //var mBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
        //.setSmallIcon(R.drawable.notification_icon)
            //need icon and to solve the "CHANNEL_ID" problem
        //.setContentTitle("Ort Report")
        //.setContentText("Have you inputted your food intake yet?")
        //.setPriority(NotificationCompat.PRIORITY_DEFAULT)
}

private fun createNotificationChannel() {
    // Create the NotificationChannel, but only on API 26+ because
    // the NotificationChannel class is new and not in the support library
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        //val name = getString(R.string.channel_name)
        //val descriptionText = getString(R.string.channel_description)
        //val importance = NotificationManager.IMPORTANCE_DEFAULT
        //val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
         //   description = descriptionText
        }
        // Register the channel with the system
        //val notificationManager: NotificationManager =
          //  getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        //notificationManager.createNotificationChannel(channel)
    }
}

