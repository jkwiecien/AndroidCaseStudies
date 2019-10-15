package com.example.myapplication.databinding.inversebindings

import androidx.databinding.DataBindingComponent

class BindingComponent : DataBindingComponent {
    override fun getCustomWayBindingViewBindings(): CustomWayBindingViewBindings =
        CustomWayBindingViewBindings()
}