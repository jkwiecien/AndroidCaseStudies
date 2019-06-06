package com.example.myapplication.customconstraintlayout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.myapplication.R

class CustomConstraintLayoutHome : Activity() {

    companion object {
        fun start(activity: Activity) {
            activity.startActivity(Intent(activity, CustomConstraintLayoutHome::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_constraint_home)
    }
}