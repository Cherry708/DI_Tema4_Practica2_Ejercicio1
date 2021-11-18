package com.example.di_tema4_practica2_ejercicio1.ui.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BooksViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is books fragment"
    }
    val text: LiveData<String> = _text
}