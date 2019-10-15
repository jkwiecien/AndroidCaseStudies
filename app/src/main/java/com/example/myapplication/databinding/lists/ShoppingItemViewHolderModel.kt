package com.example.myapplication.databinding.lists

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.databinding.LiveDataEvent

data class ShoppingItemViewHolderModel(
    val id: String,
    val name: String,
    var tickedOff: Boolean
) : ViewHolderModel {

    companion object {
        fun withShoppingItem(itemModel: ShoppingItem): ShoppingItemViewHolderModel {
            return ShoppingItemViewHolderModel(
                id = itemModel.id,
                name = itemModel.name,
                tickedOff = itemModel.tickedOff
            )
        }
    }

    val eventsLiveData = MutableLiveData<LiveDataEvent<*>>()

    fun onItemClicked(view: View) {
        onCheckedChanged(!tickedOff)
    }

    fun onCheckedChanged(checked: Boolean) {
        Log.i("ShoppingListViewModel", "$this checked changed to: $checked")
        if (checked == tickedOff) return
        tickedOff = checked
        eventsLiveData.value = LiveDataEvent(ShoppingListItemCheckedChangedPayload(this))
    }

    fun toShoppingItem(): ShoppingItem {
        return ShoppingItem(
            id = id,
            name = name,
            tickedOff = tickedOff
        )
    }

    override fun toString(): String = "$name checked: $tickedOff"

    override fun isTheSame(other: ViewHolderModel): Boolean =
        id == (other as? ShoppingItemViewHolderModel)?.id

    override fun isContentTheSame(other: ViewHolderModel): Boolean = this == other
}