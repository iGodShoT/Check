package com.example.mptfood.Models
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product
    (
        var ID : Int = 0,
        var Name: String? = null,
        var Price: Int = 0,
        var QuantityAvailable: Int = 0

    ) : Parcelable