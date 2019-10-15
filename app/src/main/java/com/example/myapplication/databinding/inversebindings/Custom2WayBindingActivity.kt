package com.example.myapplication.databinding.inversebindings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.databinding.Activity2WayBindingBinding

class Custom2WayBindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProviders
            .of(this)
            .get(Custom2WayBindingViewModel::class.java)

        val binding =
            DataBindingUtil.setContentView<Activity2WayBindingBinding>(
                this,
                R.layout.activity_2_way_binding
            )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}