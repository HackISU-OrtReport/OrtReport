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
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.*



var firstRun = true

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val EXTRA_MESSAGE = "com.ortreport.ortreport.extra.MESSAGE"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if (firstRun){
            firstRun = false
            startLoadInFunction()
        }

        val intentTracker = intent
        var processID = intentTracker.getIntExtra("processID", 0)
        var stateIDText = ""
        var trackerNum = 50
        val stateList = arrayOf("Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Missouri","Mississippi","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming")
        val surplusFoodList: DoubleArray = doubleArrayOf(1726045390.305,-45277179.372,1366968240.545,3261246259.073,16992418138.642,2290429368.742,-23371725.882,464941117.284,1319734726.958,2647254960.224,163849548.485,2744714378.278,5782599557.332,3723714471.122,10330010960.844,5977592655.723,1890205924.508,809525138.530,164258927.916,499350413.997,-236094507.398,2180881450.164,6465005560.589,1920062387.641,3457845943.807,1302589984.131,8239162317.399,56280047.646,13243798.815,-84870261.124,985050163.618,763448283.983,3663818479.194,3114068813.958,2516391352.447,2282038357.533,1583649038.429,1807283252.521,-41930656.574,553383783.186,3465503481.677,869446430.186,6922901103.069,488746855.804,272948342.716,877706120.608,3565026018.559,146772311.836,4145137043.690,522464233.787)
        var userStateID = 50
        if (processID == 0){
            // broken?
        } else if (processID == 1){
            // first run, grab state data
            stateIDText = intentTracker.getStringExtra("stateID")
            userStateID = stateList.indexOf(stateIDText)
            // trackerText.text = surplusFoodList[userStateID].toString() + " " + stateList[userStateID]
            if (surplusFoodList[userStateID] > 0){
                trackerText.text = "Good news! If " + stateList[userStateID] + " were able to reuse all of its food waste, it would be able to feed its entire food-insecure population!"
            } else {
                trackerText.text = "Aww. It doesn't look like " + stateList[userStateID] + " is currently able to support its food-insecure population with its food waste. Maybe it could with some help from it's neighbors!"
            }
        } else if (processID == 2){
            // getting data from tracker
            trackerNum = intentTracker.getIntExtra("wastedFood", 50)
        }

        processID = 0


        // trackerText.text = trackerNum.toString() + " " + stateList[trackerNum - 1]
        // trackerText.text = stateIDText


        val actionBar = supportActionBar

        actionBar!!.title = "ORTrepORT"

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

    private fun startLoadInFunction(){
        val randomIntent = Intent(this, LoadInScreen::class.java)
        startActivity(randomIntent)
    }

    fun startLoadInFunctionPub(view : View){
        val randomIntent = Intent(this, LoadInScreen::class.java)
        startActivity(randomIntent)
    }
}



