package com.ortreport.ortreport

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter
import android.widget.Button

import kotlinx.android.synthetic.main.activity_load_in_screen.*
import android.widget.Spinner



class LoadInScreen : AppCompatActivity() {

    private var spinner1: Spinner? = null
    private var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_in_screen)
        setSupportActionBar(toolbar)
    }
}