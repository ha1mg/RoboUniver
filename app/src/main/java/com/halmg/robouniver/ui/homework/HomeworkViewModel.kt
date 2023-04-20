package com.halmg.robouniver.ui.homework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeworkViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is homework Fragment"
    }
    val text: LiveData<String> = _text
}