package com.example.myapplication.databinding.lists

import androidx.annotation.Keep
import java.util.*

@Keep
data class ShoppingItem(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val tickedOff: Boolean = false
) {
    override fun toString(): String = "$name tickedOff: $tickedOff"
}