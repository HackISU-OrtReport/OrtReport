package com.ortreport.ortreport

import android.app.*
import android.app.Notification
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.preference.PreferenceActivity
import android.graphics.Color
import android.os.Build
import android.widget.RemoteViews
import android.widget.Switch

/**
 * A [PreferenceActivity] that presents a set of application settings. On
 * handset devices, settings are presented as a single list. On tablets,
 * settings are split by category, with category headers shown to the left of
 * the list of settings.
 *
 * See [Android Design: com.ortreport.ortreport.Settings](http://developer.android.com/design/patterns/settings.html)
 * for design guidelines and the [com.ortreport.ortreport.Settings API Guide](http://developer.android.com/guide/topics/ui/settings.html)
 * for more information on developing a com.ortreport.ortreport.Settings UI.
 */
class SettingsActivity : AppCompatPreferenceActivity() {
    internal lateinit var myswitch : Switch
    internal lateinit var switch1 : Switch
    lateinit var notificationManager : NotificationManager
    lateinit var notificationChannel : NotificationChannel
    lateinit var builder : Notification.Builder
    private val channelId = "com.ortreport.ortreport"
    private val description = "Remember to log in your daily food intake!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting);

        // dependencies {
        //    implementation "com.android.support:support-compat:28.0.0";
        //}need to commit and push

        /**
         * Set up the [android.app.ActionBar], if the API is available.
         */
        myswitch = findViewById(R.id.myswitch) as Switch
        switch1 = findViewById(R.id.switch1) as Switch

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        myswitch.setOnClickListener{

            val intent = Intent(this, LauncherActivity:: class.java)
            val pendingIntent = PendingIntent.getActivity(this,0, intent,PendingIntent.FLAG_UPDATE_CURRENT)

            if(myswitch.isChecked) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                    notificationChannel.enableLights(true)
                    notificationChannel.lightColor= Color.GREEN
                    notificationChannel.enableVibration(false)
                    notificationManager.createNotificationChannel(notificationChannel)

                    builder = Notification.Builder(this,channelId)
                        .setContentTitle("Ort Report")
                        .setContentText("Remember to input your daily repOrt!")
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.ic_launcher))
                        .setContentIntent(pendingIntent)

                } else {
                    builder = Notification.Builder(this)
                        .setContentTitle("Ort Report")
                        .setContentText("Remember to input your daily repOrt!")
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.ic_launcher))
                        .setContentIntent(pendingIntent)
                }
                notificationManager.notify(1234, builder.build())
            }
        }



    }
}
