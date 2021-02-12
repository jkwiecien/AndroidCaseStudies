package com.example.myapplication.livedataevents

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class EventStreamActivity : AppCompatActivity() {

    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, EventStreamActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private val viewModel by lazy {
        ViewModelProvider(this).get(EventStreamViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.events.observe(this, Observer { event ->
            Log.d("LiveData events", "Populating event: $event")
        })

        viewModel.populateEvents()
    }
}