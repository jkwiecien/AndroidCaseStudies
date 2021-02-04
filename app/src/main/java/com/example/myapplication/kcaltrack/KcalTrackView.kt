package com.example.myapplication.kcaltrack

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.annotation.ColorInt
import com.example.myapplication.R

class KcalTrackView : View {

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

    companion object {
        private val LOG_TAG = "KCAL_TRACK"
        private const val ANIM_DURATION = 500L
        private const val START_ANGLE = 270f
    }

    private var trackWidth = 0f
    private var trackPadding = 0f

    private var viewWidth = 0f
    private var viewHeight = 0f
    private var centerX = 0f
    private var centerY = 0f

    private val backgroundRect = RectF(0f, 0f, 0f, 0f)
    private val rectanglePath = Path()
    private val arcRect = RectF(0f, 0f, 0f, 0f)
    private var arcPath = Path()

    private var progress: Float = 0f
    private var arcRadius = 0f
    var arcAngle = 130f
    var arcCenterX = 0f
    var arcCenterY = 0f

    private val rectanglePaint = Paint(Paint.ANTI_ALIAS_FLAG)
        .apply {
            style = Paint.Style.STROKE
            strokeWidth = 50f
        }
    private val arcPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        .apply {
            style = Paint.Style.FILL
        }

    private fun init(context: Context) {
        rectanglePaint.color = Color.MAGENTA
        arcPaint.color = Color.GREEN

        trackWidth = context.resources.getDimension(R.dimen.kcal_track_width)
        trackPadding = trackWidth

        update(0.15f)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        viewWidth = layoutParams.width.toFloat()
        viewHeight = layoutParams.height.toFloat()

        centerX = viewWidth / 2f
        centerY = viewHeight / 2f

        arcCenterX = centerX
        arcCenterY = centerY
        arcRadius = viewWidth / 2

        with(backgroundRect) {
            left = 0f + trackPadding
            top = 0f + trackPadding
            right = viewWidth - trackPadding
            bottom = viewHeight - trackPadding
        }

        with(arcRect) {
            left = arcCenterX - arcRadius
            top = arcCenterY - arcRadius
            right = arcCenterX + arcRadius
            bottom = arcCenterY + arcRadius
        }

        rectanglePath.addRoundRect(backgroundRect, 100f, 100f, Path.Direction.CW)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.clipPath(arcPath)
        canvas.drawPath(rectanglePath, rectanglePaint)
//        canvas.drawPath(arcPath, arcPaint)
    }

    private val animatorUpdateListener = ValueAnimator.AnimatorUpdateListener {
        updateArcPath()
        invalidate()
    }

    private fun trackAnimator(progressPercent: Float): ValueAnimator {
        val angle = 360 * progressPercent
        val animator = ObjectAnimator.ofFloat(this, "arcAngle", angle)
        animator.duration = ANIM_DURATION
        animator.interpolator = DecelerateInterpolator()
        animator.addUpdateListener(animatorUpdateListener)
        return animator
    }

    private fun updateArcPath() {
        arcPath = Path()
        arcPath.addArc(arcRect, START_ANGLE, arcAngle)
        arcPath.lineTo(arcCenterX, arcCenterY)
    }

//    private fun getInterimX(): Float {
//        val aAngle = when {
//            arcAngle > 270 -> arcAngle - 270
//            arcAngle > 180 -> arcAngle - 180
//            arcAngle > 90 -> arcAngle - 90
//            else -> arcAngle
//        }
//
//        val b = cos(aAngle) * arcRadius
//        val a = abs(tan(aAngle) * b)
//        val interimX = when {
//            arcAngle > 270 -> arcAngle - 270
//            arcAngle > 180 -> arcAngle - 180
//            arcAngle > 90 -> arcAngle - 90
//            else -> arcCenterX + a
//        }
//
//        Log.d(
//            LOG_TAG,
//            "Arc X: $arcCenterX,\nprogress: $progress,\narcAngle: $arcAngle,\na: $a,\ninterimX: $interimX"
//        )
//
//        return interimX
//    }

    fun update(progressPercent: Float) {
        progress = progressPercent
        trackAnimator(progressPercent).start()
    }

    fun setTrackColor(@ColorInt color: Int) {
        rectanglePaint.color = color
    }
}