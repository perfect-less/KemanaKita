package com.example.kemanakita.preferense

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ResponseDestination(
    @field:SerializedName("destination")
    val destination : List<Listdetail?>? = null

)

@Parcelize
data class Listdetail(
    @field:SerializedName("address")
    val address: String? = null,
    @field:SerializedName("description")
    val description: String? = null,
    @field:SerializedName("id")
    val id: String? = null,
    @field:SerializedName("link_map")
    val link_map: String? = null,
    @field:SerializedName("image")
    val image: String? = null,
    @field:SerializedName("wisata")
    val wisata : String? = null
) : Parcelable
