package com.ortreport.ortreport


import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.View
import android.widget.*

import kotlinx.android.synthetic.main.activity_load_in_screen.*
import kotlinx.android.synthetic.main.trackerdatacollectionpageslider_content.*
import android.widget.AdapterView.OnItemSelectedListener




class LoadInScreen : AppCompatActivity() {

    var spinner1: Spinner? = null
    var button: Button? = null
    var selectedItemText = ""

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
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                selectedItemText = parent.getItemAtPosition(position) as String
                // Notify the selected item text
                Toast.makeText(applicationContext, "Selected : $selectedItemText", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
}

    fun lockInData(view : View){
        val takeBackIntent = Intent(this, MainActivity::class.java)
        takeBackIntent.putExtra("processID", 1)
        takeBackIntent.putExtra("stateID", selectedItemText)
        startActivity(takeBackIntent)
    }
}