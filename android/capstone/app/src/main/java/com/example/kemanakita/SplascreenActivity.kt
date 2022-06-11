package com.example.kemanakita

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import com.example.kemanakita.databinding.ActivitySplascreenBinding
@Suppress("DEPRECATION")
class SplascreenActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySplascreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplascreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Intent(this@SplascreenActivity,MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }

}