package com.example.myapplication.sharedelementtransition

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_shared_transition_c.*
import kotlinx.android.synthetic.main.activity_transition_c.imageView

class SharedTransitionActivityC : AppCompatActivity() {

    companion object {
        fun start(activity: Activity, transitions: Array<Pair<View, String>>) {
            val intent = Intent(activity, SharedTransitionActivityC::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT or Intent.FLAG_ACTIVITY_CLEAR_TOP)

            val transitionsOptions =
                ActivityOptions.makeSceneTransitionAnimation(activity, *transitions)
            activity.startActivity(intent, transitionsOptions.toBundle())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_transition_c)

        transitionButtonAtActivityC.setOnClickListener {
            SharedTransitionActivityB.start(
                this,
                arrayOf(
                    Pair(imageView as View, getString(R.string.transition_image)),
                    Pair(transitionButtonAtActivityC as View, getString(R.string.transition_button))
                )
            )
        }
    }
}