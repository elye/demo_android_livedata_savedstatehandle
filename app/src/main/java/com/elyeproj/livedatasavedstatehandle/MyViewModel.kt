package com.elyeproj.livedatasavedstatehandle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MyViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    companion object {
        const val KEY = "Key"
    }

    private val textLiveData: MutableLiveData<String>

    val textDataNotifier: LiveData<String>
        get() = textLiveData

    init {
        textLiveData = savedStateHandle.getLiveData(KEY)
    }

    fun fetchValue() {
        textLiveData.value = "From ViewModel"
        savedStateHandle.set(KEY, textLiveData.value)
    }
}
