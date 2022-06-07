package com.example.kemanakita.ui.detail

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.kemanakita.R
import com.example.kemanakita.databinding.ActivityDetailBinding
import com.example.kemanakita.preferense.Listdetail

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "auth")
class DetailActivity : AppCompatActivity() {
    private var _binding : ActivityDetailBinding? =null
    private val binding get() = _binding!!
    private lateinit var listdetail: Listdetail
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listdetail = intent.getParcelableExtra<Listdetail>(EXTRA_USERNAME) as Listdetail
        binding.apply {
            addresDetail.text = listdetail.address
            descriptionDetail.text = listdetail.description
            linkMapDetail.text= listdetail.link_map
            wisataDetail.text = listdetail.wisata
        }

    }
    companion object{
        const val EXTRA_USERNAME = "extra_username"
    }
}