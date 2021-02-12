package com.example.myapplication.livedataevents

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class EventStreamViewModel : ViewModel() {

    val events = MutableLiveData<String>()

    fun populateEvents() {

        viewModelScope.launch(Dispatchers.Main) {
            events.value = "Event A"
            delay(100)
            events.value = "Event B"
            delay(100)
            events.value = "Event C"
        }


    }
}