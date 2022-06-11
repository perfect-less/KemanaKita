package com.example.kemanakita.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kemanakita.R
import com.example.kemanakita.databinding.ItemRowsListBinding
import com.example.kemanakita.preferense.ModelListWisata

class HomeAdapter(private val listUser: ArrayList<ModelListWisata>) :
    RecyclerView.Adapter<HomeAdapter.CardViewUserHolder>() {
    inner class CardViewUserHolder(private val binding: ItemRowsListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: ModelListWisata) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(user.imageList)
                    .apply(RequestOptions().override(100, 100))
                    .into(personPhoto)
                descripsi.text = user.location
                tvItemTitle.text = user.nameWst
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewUserHolder {
        val binding =
            ItemRowsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewUserHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewUserHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount(): Int = listUser.size
}