package com.example.di_tema4_practica2_ejercicio1.ui.synopsis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SynopsisViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is synopsis Fragment"
    }
    val text: LiveData<String> = _text
}