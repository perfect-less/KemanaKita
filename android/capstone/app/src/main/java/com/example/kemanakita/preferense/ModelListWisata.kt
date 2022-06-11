package com.example.kemanakita.preferense

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelListWisata(
    var nameWst:String,
    var imageList:Int,
    var location:String
): Parcelable
