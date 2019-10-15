package com.example.myapplication.databinding.inversebindings

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import com.example.myapplication.R
import kotlinx.android.synthetic.main.view_custom_2_way_bind.view.*

class CustomWayBindingView : FrameLayout {

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
        View.inflate(context, R.layout.view_custom_2_way_bind, this)
    }

    val editText: EditText get() = editTextAt2WayBindingView
}