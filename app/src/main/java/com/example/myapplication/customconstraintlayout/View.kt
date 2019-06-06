package com.example.myapplication.customconstraintlayout

import android.animation.Animator
import android.view.View

fun View.fadeIn(animationDuration: Long) {
    animate()
        .alpha(1f)
        .setDuration(animationDuration)
        .setListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animator: Animator) {
            }

            override fun onAnimationEnd(animator: Animator) {
            }

            override fun onAnimationCancel(animator: Animator) {
            }

            override fun onAnimationStart(animator: Animator) {
                visibility = View.VISIBLE
                alpha = 0f
            }
        })
}


fun View.fadeIn() {
    fadeIn(300)
}

fun View.fadeOut(animationDuration: Long) {
    animate()
        .alpha(0f)
        .setDuration(animationDuration)
        .setListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animator: Animator) {
            }

            override fun onAnimationEnd(animator: Animator) {
                visibility = View.INVISIBLE
            }

            override fun onAnimationCancel(animator: Animator) {
            }

            override fun onAnimationStart(animator: Animator) {
                visibility = View.VISIBLE
                alpha = 1f
            }

        })
}

fun View.fadeOut() {
    fadeOut(300)
}




