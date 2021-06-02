package com.example.myapplication.transitions

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_transition_a.*

class TransitionActivityA : AppCompatActivity() {

    companion object {
        fun startWithoutAnimation(activity: Activity) {
            activity.startActivity(Intent(activity, TransitionActivityA::class.java))
        }

        fun start(activity: Activity) {
            val intent = Intent(activity, TransitionActivityA::class.java)
            val transitionsOptions = ActivityOptions.makeSceneTransitionAnimation(activity)
            activity.startActivity(intent, transitionsOptions.toBundle())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_a)

        transitionButtonAtTransitionActivityA.setOnClickListener {
            TransitionActivityB.start(this)
        }
    }
}