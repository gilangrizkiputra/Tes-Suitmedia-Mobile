package com.tes.androidtessuitmedia.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tes.androidtessuitmedia.ui.screen.secondScreen.SecondScreen


class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FirstScreenViewModel::class.java)) {
            return FirstScreenViewModel() as T
        }
        if (modelClass.isAssignableFrom(SecondScreenViewModel::class.java)) {
            return SecondScreenViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}