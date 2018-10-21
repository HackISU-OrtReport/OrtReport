package com.ortreport.ortreport

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class TipsActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tiplayout)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        val darkness = intent
        val dark = darkness.getBooleanExtra("NightMode", false)
        if (dark) {
            setTheme(R.style.DarkTheme)
        } else {
            setTheme(R.style.AppTheme)
        }

        val posts: ArrayList<String> = ArrayList()

        for (i in 1..12){
            posts.add("Helpful  Tip # $i\n")
            if(i==1){
                posts.add("Store better: If you regularly throw away stale chips/cereal/crackers/etc., try storing them in airtight containers — this should help them keep longer (or, of course, just buy fewer of these products).")
            } else if(i==2) {
                posts.add("Donate what you won’t use: Never going to eat that can of beans? Donate it to a food kitchen before it expires so it can be consumed by someone who needs it. ")
            } else if(i==3) {
                posts.add("Understand expiration dates before buying.")
            } else if(i==4) {
                posts.add("If you like to eat fruit at room temperature, but it should be stored in the refrigerator for maximum freshness, take what you’ll eat for the day out of the refrigerator in the morning.")
            } else if(i==5) {
                posts.add("Find out how to store fruits and vegetables so they stay fresh longer inside or outside your refrigerator.")
            } else if(i==6) {
                posts.add("Don’t over-fill the fridge.")
            } else if(i==7) {
                posts.add("Look in your refrigerator and cupboards first to avoid buying food you already have, make a list each week of what needs to be used up and plan upcoming meals around it.")
            } else if(i==8) {
                posts.add("Make your shopping list based on how many meals you’ll eat at home. Will you eat out this week? How often?")
            } else if(i==9) {
                posts.add("Buy only what you need and will use. Buying in bulk only saves money if you are able to use the food before it spoils.")
            } else if(i==10) {
                posts.add("Cook only what you need")
            } else if(i==11) {
                posts.add("Use up every last bit")
            } else if(i==12) {
                posts.add("When being mindful of your own food waste you also save your budget along with helping with food security.")
            }
        }

        recyclerView.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        recyclerView.adapter = PostsAdapter(posts)

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