package com.example.myapplication.kcaltrack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_kcal_track.*
import kotlin.random.Random

class KcalTrackActivity : AppCompatActivity() {

    companion object {
        fun start(activity: AppCompatActivity) {
            activity.startActivity(Intent(activity, KcalTrackActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kcal_track)

        animateLottieButton.setOnClickListener {
//            lottieView.playAnimation()
            val progressPercent = Random.nextFloat()
            lottieKcalTrackView.update(progressPercent)
        }

        animateButton.setOnClickListener {
            val progressPercent = Random.nextFloat()
            kcalTrackView.update(progressPercent)
        }
    }

}