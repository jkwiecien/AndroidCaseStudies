package com.example.myapplication.databinding.inversebindings

import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.lifecycle.LiveData

class CustomWayBindingViewBindings {

    companion object {
        @JvmStatic
        @InverseBindingAdapter(attribute = "text", event = "textAttrChanged")
        fun CustomWayBindingView.getText(): String? {
            return editText.text.toString()
        }
    }

    @BindingAdapter("text")
    fun CustomWayBindingView.setText(liveData: LiveData<String>) {
        if (liveData.value != editText.text.toString()) editText.setText(liveData.value)
    }

    @BindingAdapter("textAttrChanged")
    fun CustomWayBindingView.onTextChanged(listener: InverseBindingListener?) {
        if (listener != null) {
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(
                    text: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int
                ) {
                    listener.onChange()
                }

                override fun afterTextChanged(editable: Editable) {}
            })
        }
    }

}