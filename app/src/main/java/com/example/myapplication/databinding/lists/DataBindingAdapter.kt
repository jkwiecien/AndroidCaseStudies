package com.example.myapplication.databinding.lists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class DataBindingAdapter<T>(diffCallback: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, DataBindingViewHolder<T>>(diffCallback) {

    companion object {
        val defaultDiffCallback = object : DiffUtil.ItemCallback<ViewHolderModel>() {
            override fun areItemsTheSame(
                oldItem: ViewHolderModel,
                newItem: ViewHolderModel
            ): Boolean = newItem.isTheSame(oldItem)

            override fun areContentsTheSame(
                oldItem: ViewHolderModel,
                newItem: ViewHolderModel
            ): Boolean = newItem.isContentTheSame(oldItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder<T> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        return DataBindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder<T>, position: Int) =
        holder.bind(getItem(position))

    abstract override fun getItemViewType(position: Int): Int
}