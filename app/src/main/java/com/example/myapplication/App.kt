package com.example.myapplication

import android.app.Application
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.inversebindings.BindingComponent

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        DataBindingUtil.setDefaultComponent(BindingComponent())
    }
}