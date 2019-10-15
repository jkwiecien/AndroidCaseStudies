package com.example.myapplication.databinding.lists

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.databinding.LiveDataEvent

class ShoppingListViewModel : ViewModel() {

    var itemsRepository: List<ShoppingItem> = listOf(
        ShoppingItem(name = "Bread"),
        ShoppingItem(name = "Butter"),
        ShoppingItem(name = "Salad"),
        ShoppingItem(name = "Tomatoes"),
        ShoppingItem(name = "Milk", tickedOff = true)
    )

    val itemsLiveData = MutableLiveData<List<ViewHolderModel>>()

    val eventsMediatorLiveData = MediatorLiveData<LiveDataEvent<*>>()

    fun loadData() {
//        itemsLiveData.value?.filterIsInstance<ShoppingItemViewHolderModel>()
//            ?.forEach { eventsMediatorLiveData.removeSource(it.eventsLiveData) }

        val items = itemsRepository.map {
            ShoppingItemViewHolderModel.withShoppingItem(it).apply {
                eventsMediatorLiveData.addSource(eventsLiveData) { event ->
                    eventsMediatorLiveData.value = event
                }
            }
        }

        val uncheckedItems = items.filter { !it.tickedOff }
        val checkedItems = items.filter { it.tickedOff }

        itemsLiveData.value = uncheckedItems.plus(checkedItems)
    }


    fun onCheckedChanged() {
//        val items: List<ShoppingItemViewHolderModel> =
//            itemsLiveData.value?.filterIsInstance<ShoppingItemViewHolderModel>()?.map { it.copy(id = UUID.randomUUID().toString()) }
//                ?: emptyList()
//
//        val uncheckedItems = items.filter { !it.tickedOff }
//        val checkedItems = items.filter { it.tickedOff }
//
//        itemsLiveData.value = uncheckedItems.plus(checkedItems)


        itemsRepository =
            itemsLiveData.value?.filterIsInstance<ShoppingItemViewHolderModel>()?.map { vhModel ->
                Log.i("ShoppingListViewModel", "Item: $vhModel")
                vhModel.toShoppingItem()
            }
                ?: emptyList()

        loadData()
    }
}