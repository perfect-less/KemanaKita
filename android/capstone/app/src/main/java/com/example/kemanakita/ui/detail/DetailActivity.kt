package com.example.kemanakita.ui.detail

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.kemanakita.R
import com.example.kemanakita.databinding.ActivityDetailBinding

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "auth")
class DetailActivity : AppCompatActivity() {
    private var _binding : ActivityDetailBinding? =null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}