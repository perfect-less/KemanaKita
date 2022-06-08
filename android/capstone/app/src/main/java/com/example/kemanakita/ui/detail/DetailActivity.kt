package com.example.kemanakita.ui.detail

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.signature.ObjectKey
import com.example.kemanakita.R
import com.example.kemanakita.databinding.ActivityDetailBinding
import com.example.kemanakita.preferense.Listdetail
import com.google.gson.Gson

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "auth")
class DetailActivity : AppCompatActivity() {
    private var _binding : ActivityDetailBinding? =null
    private val binding get() = _binding!!
    private var listdetail: Listdetail? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listdetail = Gson().fromJson(
            intent.getStringExtra(EXTRA_USERNAME),
            Listdetail::class.java
        )
        binding.apply {
            addresDetail.text = listdetail?.address
            descriptionDetail.text = listdetail?.description
            linkMapDetail.text= listdetail?.link_map
            image.let {
                Glide.with(this@DetailActivity)
                    .load(listdetail?.image?: "")
                    .placeholder(R.drawable.ic_baseline_cameraswitch_24)
                    .error(R.drawable.ic_baseline_cameraswitch_24)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .signature(ObjectKey(listdetail?.link_map ?: ""))
                    .into(it)
            }
            wisataDetail.text = listdetail?.wisata
        }

    }
    companion object{
        const val EXTRA_USERNAME = "extra_username"
    }
}