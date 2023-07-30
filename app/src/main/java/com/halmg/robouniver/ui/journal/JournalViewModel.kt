package com.halmg.robouniver.ui.journal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JournalViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "ЗДЕСЬ БУДЕТ ЖУРНАЛ"
    }
    val text: LiveData<String> = _text
}