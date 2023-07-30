package com.halmg.robouniver.ui.home.wages

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WagesViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "ЗДЕСЬ БУДЕТ ОТЧЕТ ПО ЗП"
    }
    val text: LiveData<String> = _text
}