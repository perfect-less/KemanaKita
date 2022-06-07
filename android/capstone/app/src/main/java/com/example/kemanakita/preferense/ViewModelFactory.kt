package com.example.kemanakita.preferense

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kemanakita.ui.dashboard.DashboardViewModel
import com.example.kemanakita.ui.detail.ViewModelDetail

class ViewModelFactory(private val pref : DestinationPreference)
    :ViewModelProvider.NewInstanceFactory() {
    private lateinit var mApplication: Application

    fun setApplication(application: Application) {
        mApplication = application
    }

    @Suppress("UNCHECKED_CAST")

    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        if (modelClass.isAssignableFrom(DashboardViewModel::class.java)){
            return DashboardViewModel(pref) as T
        }
        if(modelClass.isAssignableFrom(ViewModelDetail::class.java)){
            return ViewModelDetail(pref) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}