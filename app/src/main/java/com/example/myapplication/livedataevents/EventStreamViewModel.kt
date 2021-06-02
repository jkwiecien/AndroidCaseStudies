package com.example.myapplication.livedataevents

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventStreamViewModel : ViewModel() {

    val events = MutableLiveData<String>()

    fun populateEvents() {
        viewModelScope.launch(Dispatchers.Main) {
            events.value = "Event A"
            events.value = "Event B"
            events.value = "Event C"
        }

        events.value = "Event A"
        events.value = "Event B"
        events.value = "Event C"
    }
}