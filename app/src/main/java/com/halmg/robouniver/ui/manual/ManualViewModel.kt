package com.halmg.robouniver.ui.manual

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ManualViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Здсь будет какой-то текст"
    }
    val text: LiveData<String> = _text
}