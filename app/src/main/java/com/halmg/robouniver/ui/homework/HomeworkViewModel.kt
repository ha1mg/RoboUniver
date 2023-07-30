package com.halmg.robouniver.ui.homework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeworkViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "ЗДЕСЬ БУДЕТ ЭКРАН С ДОМАШНИМИ РАБОТАМИ УЧЕНИКОВ"
    }
    val text: LiveData<String> = _text
}