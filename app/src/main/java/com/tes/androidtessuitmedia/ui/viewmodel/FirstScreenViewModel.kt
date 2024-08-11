package com.tes.androidtessuitmedia.ui.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FirstScreenViewModel : ViewModel() {

    var name: MutableState<String> = mutableStateOf("")
        private set

    var palindrome: MutableState<String> = mutableStateOf("")
        private set


    fun onNameChange(newName: String) {
        name.value = newName
    }

    fun onPalindromeChange(newPalindrome: String) {
        palindrome.value = newPalindrome
    }

    fun checkPalindrome(context: Context) {
        viewModelScope.launch {
            val reversedInputString = palindrome.value.reversed()

            if (palindrome.value == reversedInputString) {
                Toast.makeText(context, "isPalindrome", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, "not palindrome", Toast.LENGTH_LONG).show()
            }
        }
    }
}
