package com.example.myapplication.fullscreen

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_fullscreen.*


class FullscreenActivity : AppCompatActivity() {


    companion object {
        const val LOG_TAG = "Sample: FullScreen"

        fun start(activity: AppCompatActivity) {
            activity.startActivity(Intent(activity, FullscreenActivity::class.java))
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen)

        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { v, insets ->
            val toolbarHeight = toolbarAtFullScreenActivity.height
            toolbarAtFullScreenActivity.layoutParams =
                (toolbarAtFullScreenActivity.layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        val topInset = insets.systemWindowInsetTop
                        val defaultToolbarHeight = getToolbarHeight()
                        Log.i(
                            LOG_TAG,
                            "Top inset: $topInset, defaultToolbarHeight: $defaultToolbarHeight"
                        )
                        height = getToolbarHeight() + topInset
                    } else {
                        //nvm
                    }
                }
            insets
        }

        imageAtFullScreenActivity.setOnClickListener { if (toolbarAtFullScreenActivity.visibility == View.VISIBLE) hideSystemUi() else showSystemUI() }
    }

    private fun getToolbarHeight(): Int {
        val tv = TypedValue()
        return if (theme.resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            TypedValue.complexToDimensionPixelSize(tv.data, resources.displayMetrics)
        } else 0
    }

    private fun hideSystemUi() {
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                )

        toolbarAtFullScreenActivity.visibility = View.INVISIBLE
    }

    private fun showSystemUI() {
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                )

        toolbarAtFullScreenActivity.visibility = View.VISIBLE
    }

}