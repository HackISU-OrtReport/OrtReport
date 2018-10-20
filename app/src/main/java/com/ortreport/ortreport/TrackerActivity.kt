package com.ortreport.ortreport

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

// import kotlinx.android.synthetic.main.activity_main.*
// import kotlinx.android.synthetic.main.content_main.*
import android.support.v4.content.ContextCompat.startActivity
import android.widget.SeekBar


import kotlinx.android.synthetic.main.trackerdatacollectionpageslider_activity.*
import kotlinx.android.synthetic.main.trackerdatacollectionpageslider_content.*
import android.widget.Toast




class TrackerActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trackerdatacollectionpageslider_activity)
        // setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar

        actionBar!!.title = "Ort Report"

        simpleSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            var progressChangedValue = 0

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                progressChangedValue = progress
                ortReporter.text = "$progress %"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                Toast.makeText(
                    this@TrackerActivity, "Seek bar progress is :$progressChangedValue",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

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
            R.id.action_settings -> {
                text_view2.text = "Settings"
                val randomIntent = Intent(this, SettingsActivity::class.java)
                startActivity(randomIntent)
                return true
            }
            R.id.action_home -> {
                text_view2.text = "Home"
                val randomIntent = Intent(this, MainActivity::class.java)
                this.startActivity(randomIntent)
                return true
            }
            R.id.action_tips -> {
                text_view2.text = "Tips"
                return true
            }
            R.id.action_tracker -> {
                text_view2.text = "Tracker"
                val randomIntent = Intent(this, TrackerActivity::class.java)
                this.startActivity(randomIntent)
                return true
            }
        }
            return super.onOptionsItemSelected(item)

        }

    }

