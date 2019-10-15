package com.example.myapplication.databinding.lists

interface ViewHolderModel {
    fun isTheSame(other: ViewHolderModel): Boolean
    fun isContentTheSame(other: ViewHolderModel): Boolean
}