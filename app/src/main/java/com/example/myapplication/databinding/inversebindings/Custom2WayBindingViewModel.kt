package com.example.myapplication.databinding.inversebindings

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Custom2WayBindingViewModel : ViewModel() {
    val nameLiveData = MutableLiveData<String>().apply { value = "some text" }
}