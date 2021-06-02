package com.example.myapplication.transitions

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class TransitionActivityC : AppCompatActivity() {

    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, TransitionActivityC::class.java)
            val transitionsOptions = ActivityOptions.makeSceneTransitionAnimation(activity)
            activity.startActivity(intent, transitionsOptions.toBundle())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_c)
    }
}