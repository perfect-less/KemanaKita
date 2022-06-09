package com.example.kemanakita.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kemanakita.R
import com.example.kemanakita.preferense.ModelListWisata

class HomeAdapter(private val wisatalist: ArrayList<ModelListWisata>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var imgphoto: ImageView = itemview.findViewById(R.id.person_photo)
        var tvname: TextView = itemview.findViewById(R.id.tv_item_title)
        var tvlocation: TextView = itemview.findViewById(R.id.descripsi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rows_list, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val (imageList, nameWst, location) = wisatalist[position]
        holder.imgphoto.setImageResource(imageList)
        holder.tvname.text = nameWst
        holder.tvlocation.text = location

    }

    override fun getItemCount(): Int = wisatalist.size
}