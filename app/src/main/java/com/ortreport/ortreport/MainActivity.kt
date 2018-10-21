package com.ortreport.ortreport

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.content.ContextCompat.startActivity
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.EditText
import android.widget.TextView
import android.provider.AlarmClock.EXTRA_MESSAGE
//repushing




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val EXTRA_MESSAGE = "com.ortreport.ortreport.extra.MESSAGE"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val intentTracker = intent
        val trackerNum = intentTracker.getIntExtra("wastedFood", 50)
        val stateList = arrayOf("Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Missouri","Mississippi","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming")
        val fsnList: DoubleArray = doubleArrayOf(414457756.0,59749342.8,517044095.2,251472370.8,2519695371.0,348889547.2,230596930.4,62196235.92,1586675646.0,797384990.6,95770546.83,113273038.2,682414723.6,415963359.4,170930571.8,189078966.7,322758456.3,394619731.8,110230718.9,359546388.6,384563109.8,692896010.1,263303000.7,437562022.8,311037443.6,65298601.62,112144707.2,195597403.3,67846710.75,506190695.6,163472449.1,1267262896.0,786061765.4,29713374.18,845866675.1,319131308.2,269327331.6,839176971.4,69787907.28,342906804.2,52983696.57,505869147.0,1990685843.0,188003779.7,44528490.72,478230465.7,457866439.0,129045724.1,296329939.9,39377821.14)

        trackerText.text = trackerNum.toString() + " " + stateList[trackerNum - 1]
        val actionBar = supportActionBar

        actionBar!!.title = "Ort Report"

        val darkness = intent
        val dark = darkness.getBooleanExtra("NightMode", false)
        if (dark) {
            setTheme(R.style.DarkTheme)
        } else {
            setTheme(R.style.AppTheme)
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
        when(item.itemId) {
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



    private fun startMainFunction(){
        val randomIntent = Intent(this, MainActivity::class.java)
        startActivity(randomIntent)
    }

    private fun startTipsFunction(){
        val randomIntent = Intent(this, TipsActivity::class.java)
        startActivity(randomIntent)
    }

    private fun startTrackerFunction(){
        val randomIntent = Intent(this, TrackerActivity::class.java)
        startActivity(randomIntent)
    }

    private fun startSettingsFunction(){
        val randomIntent = Intent(this, SettingsActivity::class.java)
        startActivity(randomIntent)
    }

}

