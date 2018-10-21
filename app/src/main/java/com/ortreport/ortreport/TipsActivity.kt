package com.ortreport.ortreport

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView

class TipsActivity : AppCompatActivity() {

    var array = arrayOf("Store better: If you regularly throw away stale chips/cereal/crackers/etc., try storing them in airtight containers — this should help them keep longer (or, of course, just buy fewer of these products).","Donate what you won’t use: Never going to eat that can of beans? Donate it to a food kitchen before it expires so it can be consumed by someone who needs it. ","Understand expiration dates before buying.","If you like to eat fruit at room temperature, but it should be stored in the refrigerator for maximum freshness, take what you’ll eat for the day out of the refrigerator in the morning.","Find out how to store fruits and vegetables so they stay fresh longer inside or outside your refrigerator.","Don’t over-fill the fridge.","Look in your refrigerator and cupboards first to avoid buying food you already have, make a list each week of what needs to be used up and plan upcoming meals around it.","Make your shopping list based on how many meals you’ll eat at home. Will you eat out this week? How often?","Buy only what you need and will use. Buying in bulk only saves money if you are able to use the food before it spoils.","Cook only what you need","Use up every last bit","When being mindful of your own food waste you also save your budget along with helping with food security.")
//repushing
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tiplayout)

        val adapter = ArrayAdapter(this,R.layout.listview_item, array)

        val listView: ListView = findViewById(R.id.listview_1)
        listView.setAdapter(adapter)

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
