package com.example.myapplication.measurementwidget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import com.example.myapplication.R
import com.example.myapplication.customconstraintlayout.fadeIn
import kotlinx.android.synthetic.main.view_measurement_reminder.view.*


class MeasurementReminderView : FrameLayout {

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    private var animationCallback: Animatable2Compat.AnimationCallback? = null

    private fun init(context: Context) {
        isClickable = true
        View.inflate(context, R.layout.view_measurement_reminder, this)

        setOnClickListener {
            if (isSelected) resetToNotLoggedState()
            else animateToLoggedState()
        }
    }

    fun animateToLoggedState() {
        isSelected = true
        val fadeInAnimation = AnimationUtils.loadAnimation(context, R.anim.anim_fade_in)
        goodJobLabelAtMeasurementReminderView.startAnimation(fadeInAnimation)

//        val animationDrawable: AnimatedVectorDrawable =
//            ContextCompat.getDrawable(context, R.drawable.anim_logbook_register_measurement)
//                    as AnimatedVectorDrawable
//
//        val callback = object : Animatable2Compat.AnimationCallback() {
//            override fun onAnimationStart(drawable: Drawable?) {
//                super.onAnimationStart(drawable)
//                registerLabelAtMeasurementReminderView.fadeOut(200)
//            }
//
//            override fun onAnimationEnd(drawable: Drawable) {
//                animationCallback?.let {
//                    AnimatedVectorDrawableCompat.unregisterAnimationCallback(
//                        animationDrawable,
//                        it
//                    )
//                }
//                animationCallback = null
//                isSelected = true
////                animatedBackgroundAtMeasurementReminderView.setImageResource(R.drawable.selector_measurement_reminder_background)
////                goodJobLabelAtMeasurementReminderView.fadeIn(600)
//            }
//        }
//
//        goodJobLabelAtMeasurementReminderView.fadeIn(800)
//
//        AnimatedVectorDrawableCompat.registerAnimationCallback(animationDrawable, callback)
//        animationCallback = callback
//        animatedBackgroundAtMeasurementReminderView.setImageDrawable(animationDrawable)
//        animationDrawable.start()
    }

    fun resetToNotLoggedState() {
        isSelected = false
        animatedBackgroundAtMeasurementReminderView.setImageResource(R.drawable.selector_measurement_reminder_background)
        registerLabelAtMeasurementReminderView.fadeIn(600)
        goodJobLabelAtMeasurementReminderView.visibility = View.INVISIBLE
    }
}