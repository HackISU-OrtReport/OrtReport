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




class LoadInScreenTwo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_in_screen_two)
        setSupportActionBar(toolbar)
    }
}