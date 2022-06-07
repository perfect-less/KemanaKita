package com.example.kemanakita.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kemanakita.preferense.DestinationPreference
import kotlinx.coroutines.launch

class DashboardViewModel(private val pref: DestinationPreference)  : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text


    fun saveDescription(user: String) {
        viewModelScope.launch {
            pref.saveDescription(user)
        }
    }

    fun logout() = removeDescription()

    fun removeDescription() {
        viewModelScope.launch {
            pref.removeDescription()
        }
    }

    fun getDescription() {
        viewModelScope.launch {
            pref.getDescription()
        }
    }
}