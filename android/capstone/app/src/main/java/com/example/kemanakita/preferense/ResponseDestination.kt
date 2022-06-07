package com.example.kemanakita.preferense

import com.google.gson.annotations.SerializedName

data class ResponseDestination(
    @field:SerializedName("destination")
    val destination : Listdetail?=null,

)

data class Listdetail(
    @field:SerializedName("description")
    val description: String? = null
)
