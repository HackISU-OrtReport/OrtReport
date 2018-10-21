package com.ortreport.ortreport

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button

import kotlinx.android.synthetic.main.activity_load_in_screen.*
import android.widget.Spinner
import kotlinx.android.synthetic.main.trackerdatacollectionpageslider_content.*
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener




class LoadInScreen : AppCompatActivity() {

    var spinner1: Spinner? = null
    var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_in_screen)
        setSupportActionBar(toolbar)
        val darkness = intent
        val dark = darkness.getBooleanExtra("NightMode", false)
        if (dark) {
            setTheme(R.style.DarkTheme)
        } else {
            setTheme(R.style.AppTheme)
        }
        val spinner: Spinner = findViewById(R.id.spinner1)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.states_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }
    fun lockInData(view : View){
        var stateText = R.id.spinner1
        val takeBackIntent = Intent(this, MainActivity::class.java)
        var state = 0
        // takeBackIntent.putExtra("stateID", )
        startActivity(takeBackIntent)
    }
}