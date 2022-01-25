package com.example.mptfood.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OrderContent
    (
        var ID : Int = 0,
        var OrderID : Int = 0,
        var ProductID : Int = 0,
        var Quantity : Int = 0

    ) : Parcelable