package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.transitions.TransitionActivityA
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runDefaultAction()

        buttonAtMainActivity.setOnClickListener { runDefaultAction() }
    }

    private fun runDefaultAction() {
//        MeasurementWidgetActivity.start(this)
//        startActivity(Intent(this, TranslucentStatusBarActivity::class.java))
//        ShoppingListActivity.start(this)
//        FullscreenActivity.start(this)
//        KcalTrackActivity.start(this)
//        SharedTransitionActivityA.start(this)
//        EventStreamActivity.start(this)
//        NumberDecimalActivity.start(this)

        buttonAtMainActivity.postDelayed({ TransitionActivityA.start(this) }, 300)
    }
}
