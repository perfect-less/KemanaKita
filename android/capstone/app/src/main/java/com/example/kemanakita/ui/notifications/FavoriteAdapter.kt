package com.example.kemanakita.ui.notifications

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kemanakita.databinding.ItemRowsFavoritBinding
import com.example.kemanakita.preferense.ModelListWisata

class FavoriteAdapter(private val listvafovorite: ArrayList<ModelListWisata>) :
    RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {
    inner class FavoriteViewHolder(private val binding: ItemRowsFavoritBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ModelListWisata) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.imageList)
                    .apply(RequestOptions().override(100, 100))
                    .into(imageFavorite)
                favoriteDescripsi.text = data.nameWst
                favoriteItemTitle.text = data.location
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding =
            ItemRowsFavoritBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(listvafovorite[position])
    }

    override fun getItemCount(): Int = listvafovorite.size
}