package com.example.kemanakita.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kemanakita.R
import com.example.kemanakita.databinding.ItemRowsListBinding
import com.example.kemanakita.preferense.ModelListWisata

class HomeAdapter(private val wisatalist: ArrayList<ModelListWisata>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    class HomeViewHolder(private val binding: ItemRowsListBinding): RecyclerView.ViewHolder(binding.root) {
        var imgPhoto: ImageView = binding.personPhoto
        var tvName: TextView = binding.tvItemTitle
        var tvDescription: TextView = binding.descripsi
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemRowsListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val (photo,name, description ) = wisatalist[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
    }

    override fun getItemCount(): Int = wisatalist.size


}