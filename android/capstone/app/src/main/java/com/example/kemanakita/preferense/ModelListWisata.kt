package com.example.kemanakita.preferense

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelListWisata(
    var imageList:Int,
    var nameWst:String,
    var location:String
): Parcelable
