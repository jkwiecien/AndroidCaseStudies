package com.example.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.myapplication.measurementwidget.MeasurementWidgetActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MeasurementWidgetActivity.start(this)
    }
}
