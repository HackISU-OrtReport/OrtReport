package com.ortreport.ortreport

import android.app.*
import android.app.Notification
import android.content.Context
import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.os.Bundle
import android.preference.PreferenceActivity
import android.graphics.Color
import android.os.Build
import android.widget.RemoteViews
import android.widget.Switch
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatDelegate
import android.view.View
import android.widget.SeekBar


import kotlinx.android.synthetic.main.activity_setting.*
import android.widget.Toast


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
class SettingsActivity : AppCompatActivity() {
    internal lateinit var myswitch: Switch
    internal lateinit var switch1: Switch
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private var isDark = false
    private val channelId = "com.ortreport.ortreport"
    private val description = "Remember to log in your daily food intake!"
    /**/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        // dependencies {
        //    implementation "com.android.support:support-compat:28.0.0";
        //}need to commit and push

        /*
         * Set up the [android.app.ActionBar], if the API is available.
        */


        switch1 = findViewById(R.id.switch1) as Switch
        myswitch = findViewById(R.id.myswitch) as Switch


        if (myswitch.isChecked) {
            //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            setTheme(R.style.DarkTheme)
            restartApp()
        } else {
           // AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            setTheme(R.style.AppTheme)
            restartApp()
        }



        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        switch1.setOnClickListener {

            val intent = Intent(this, LauncherActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            if (switch1.isChecked) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    notificationChannel =
                            NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                    notificationChannel.enableLights(true)
                    notificationChannel.lightColor = Color.GREEN
                    notificationChannel.enableVibration(false)
                    notificationManager.createNotificationChannel(notificationChannel)

                    builder = Notification.Builder(this, channelId)
                        .setContentTitle("ORTrepORT")
                        .setContentText("Remember to input your daily repOrt!")
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher))
                        .setContentIntent(pendingIntent)

                } else {
                    builder = Notification.Builder(this)
                        .setContentTitle("ORTrepORT")
                        .setContentText("Remember to input your daily repOrt!")
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher))
                        .setContentIntent(pendingIntent)
                }
                notificationManager.notify(1234, builder.build())
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_home -> {
                startMainFunction()
            }
            R.id.action_tips -> {
                startTipsFunction()
            }
            R.id.action_tracker -> {
                startTrackerFunction()
            }
            R.id.action_settings -> {
                startSettingsFunction()
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun startMainFunction() {
        val randomIntent = Intent(this, MainActivity::class.java)
        startActivity(randomIntent)
    }

    private fun startTipsFunction() {
        val randomIntent = Intent(this, TipsActivity::class.java)
        startActivity(randomIntent)
    }

    private fun startTrackerFunction() {
        val randomIntent = Intent(this, TrackerActivity::class.java)
        startActivity(randomIntent)
    }

    private fun startSettingsFunction() {
        val randomIntent = Intent(this, SettingsActivity::class.java)
        startActivity(randomIntent)
    }

    private fun restartApp() {
        val i = Intent(this, SettingsActivity::class.java)
        startActivity(i)
        finish()
    }

}
