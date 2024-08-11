package com.tes.androidtessuitmedia.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class SecondScreenViewModel: ViewModel() {
    var userName: MutableState<String> = mutableStateOf("")
        private set

    fun setUserName(name: String) {
        userName.value = name
    }

    var selectedUserName: MutableState<String?> = mutableStateOf("")
        private set

    fun setSelectedUserName(name: String) {
        selectedUserName.value = name
    }
}