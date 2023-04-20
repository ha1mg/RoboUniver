package com.halmg.robouniver.ui.home.shedule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SheduleViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is shedule Fragment"
    }
    val text: LiveData<String> = _text
}