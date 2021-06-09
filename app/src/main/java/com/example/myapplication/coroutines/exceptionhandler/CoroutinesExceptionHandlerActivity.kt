package com.example.myapplication.coroutines.exceptionhandler

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_coroutine_exception_handler.*

class CoroutinesExceptionHandlerActivity : AppCompatActivity() {

    companion object {
        fun start(activity: AppCompatActivity) {
            activity.startActivity(Intent(activity, CoroutinesExceptionHandlerActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_exception_handler)

        val viewModel: CoroutinesExceptionHandlerViewModel by viewModels()

        viewModel.labelData.observe(this, { text ->
            labelAtCoroutineExceptionHandlerActivity.text = text
        })

        viewModel.runCoroutine()
    }

}