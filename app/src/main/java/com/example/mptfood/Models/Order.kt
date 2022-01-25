package com.example.mptfood.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Order
    (
        var ID: Int = 0,
        var ClientID: Int = 0,
        var EmployeeID: Int = 0,
        var StatusID: Int = 0,
        var Date: Date? = null,
        var Total: Double = 0.0,

    ) : Parcelable