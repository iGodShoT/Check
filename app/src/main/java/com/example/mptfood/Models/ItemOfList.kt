package com.example.mptfood.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ItemOfList(
    val ID : String,
    val Name: String,
    val Description: String,
    val Price : Int,
    val ImgUrl : String
) : Parcelable