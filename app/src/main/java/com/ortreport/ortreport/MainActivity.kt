package com.ortreport.ortreport

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Hey! You tapped me!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val actionBar = supportActionBar

        actionBar!!.title = "Ort Report"
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
                text_view.text = "Settings"
                return true
            }
            R.id.action_home -> {
                text_view.text = "Home"
                return true
            }
            R.id.action_tips -> {
                text_view.text = "Tips"
                return true
            }
            R.id.action_tracker -> {
                text_view.text = "Tracker"
                return true
            }
        }
            return super.onOptionsItemSelected(item)

        }
    }
