package com.example.myapplication

import android.content.Context
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

class GlassView : FrameLayout {
    var onStatusChanged: ((filled: Boolean) -> Unit)? = null
    private var filled = false
    private var animationCallback: Animatable2Compat.AnimationCallback? = null
    private var playing = false

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context) {
        foreground = ContextCompat.getDrawable(context, R.drawable.empty_glass)
        setBackgroundResource(if (filled) R.drawable.ic_glass_minus else R.drawable.ic_glass_plus)

        setOnClickListener {
            if (!playing) {
                val animationDrawable: AnimatedVectorDrawable =
                    ContextCompat.getDrawable(
                        context,
                        if (filled) R.drawable.anim_glass_1_to_0 else R.drawable.anim_glass_0_to_1
                    ) as AnimatedVectorDrawable

                onStatusChanged?.invoke(filled)
                filled = !filled

                val callback = object : Animatable2Compat.AnimationCallback() {

                    override fun onAnimationStart(drawable: Drawable?) {
                        playing = true
                    }

                    override fun onAnimationEnd(drawable: Drawable) {
                        playing = false
                        animationCallback?.let {
                            AnimatedVectorDrawableCompat.unregisterAnimationCallback(
                                animationDrawable,
                                it
                            )
                        }
                        animationCallback = null
                    }
                }

                AnimatedVectorDrawableCompat.registerAnimationCallback(animationDrawable, callback)
                animationCallback = callback
                background = animationDrawable
                animationDrawable.start()
            }
        }
    }
}