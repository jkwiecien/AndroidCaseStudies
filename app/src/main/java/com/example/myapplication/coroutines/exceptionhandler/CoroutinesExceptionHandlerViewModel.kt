package com.example.myapplication.coroutines.exceptionhandler

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.DevDebugLog
import kotlinx.coroutines.*

class CoroutinesExceptionHandlerViewModel : ViewModel() {

    val labelData = MutableLiveData<String>()

    fun runCoroutine() {
        val eh = MainThreadExceptionHandler { coroutineContext, throwable ->
            DevDebugLog.log("Error intercepted: ${throwable.message}. \nContext: $coroutineContext")
            labelData.value = "Error intercepted"
        }

        viewModelScope.launch(Dispatchers.Main + eh) {
            val deferred1 = async(Dispatchers.IO) {
                delay(1000)
                throw RuntimeException("Throwing from async")
            }

            val deferred2 = async(Dispatchers.Default) {
                delay(1500)
                DevDebugLog.log("Task 2 finished")
            }

            awaitAll(deferred1, deferred2)
        }
    }
}