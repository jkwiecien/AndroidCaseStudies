package com.example.myapplication.kcaltrack

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import com.airbnb.lottie.LottieAnimationView
import com.example.myapplication.R


class LottieKcalTrackView : LottieAnimationView {

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }

    private fun init(context: Context) {
        setAnimation(R.raw.track_lottie_animation)
    }

    fun update(progressPercent: Float) {
        val animator = ValueAnimator.ofFloat(0f, progressPercent)
        animator.addUpdateListener { animation: ValueAnimator ->
            val value: Float = animation.animatedValue as Float
            progress = value
        }
        animator.start()
    }
}