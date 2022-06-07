package com.example.kemanakita.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kemanakita.preferense.DestinationPreference
import kotlinx.coroutines.launch

class ViewModelDetail(private val pref:DestinationPreference):ViewModel() {

    fun getDescription() {
        viewModelScope.launch {
            pref.getDescription()
        }
    }

    fun saveDescription(user: String) {
        viewModelScope.launch {
            pref.saveDescription(user)
        }
    }
}