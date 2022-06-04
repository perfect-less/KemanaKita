package com.example.kemanakita.ui.dashboard.kamera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kemanakita.R
import com.example.kemanakita.databinding.ActivityKameraBinding

class KameraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKameraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKameraBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}