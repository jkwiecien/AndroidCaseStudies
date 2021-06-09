package com.example.myapplication

import android.util.Log

object DevDebugLog {
    fun log(message: String) {
        if (BuildConfig.DEBUG) Log.v("dev-debug", " $message")
    }
}