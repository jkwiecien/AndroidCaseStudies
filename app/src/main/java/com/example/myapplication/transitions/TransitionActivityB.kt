package com.example.myapplication.transitions

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_transition_b.*

class TransitionActivityB : AppCompatActivity() {

    companion object {
        fun start(activity: Activity, transitions: Array<Pair<View, String>>) {
            val intent = Intent(activity, TransitionActivityB::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT or Intent.FLAG_ACTIVITY_CLEAR_TOP)

            val transitionsOptions =
                ActivityOptions.makeSceneTransitionAnimation(activity, *transitions)
            activity.startActivity(intent, transitionsOptions.toBundle())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_b)

        transitionButtonAtActivityB.setOnClickListener {
            TransitionActivityC.start(
                this,
                arrayOf(
                    Pair(imageAtActivityB as View, getString(R.string.transition_image)),
                    Pair(transitionButtonAtActivityB as View, getString(R.string.transition_button))
                )
            )
        }

        transitionToAButtonAtActivityB.setOnClickListener {
            TransitionActivityA.start(
                this,
                arrayOf(
                    Pair(imageAtActivityB as View, getString(R.string.transition_image)),
                    Pair(transitionButtonAtActivityB as View, getString(R.string.transition_button))
                )
            )
        }
    }
}