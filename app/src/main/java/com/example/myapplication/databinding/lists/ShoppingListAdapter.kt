package com.example.myapplication.databinding.lists

import com.example.myapplication.R


/**
 * Created by Jacek Kwiecień on 24.07.2017.
 */
class ShoppingListAdapter : DataBindingAdapter<ViewHolderModel>(defaultDiffCallback) {

    override fun getItemViewType(position: Int): Int = when (getItem(position)) {
        is ShoppingItemViewHolderModel -> R.layout.view_shopping_list_item
        else -> 0
    }
}