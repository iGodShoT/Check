package com.example.mptfood.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Client
    (
        var ID: Int = 0,
        var Surname: String? = null,
        var Name: String? = null,
        var Middlename: String? = null,
        var Email: String? = null,
        var Telephone: String? = null,

    ) : Parcelable