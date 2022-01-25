package com.example.mptfood.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Employee
    (
        var ID: Int = 0,
        var Surname: String? = null,
        var Name: String? = null,
        var Middlename: String? = null,
        var Birthdate: Date? = null,
        var Address: String? = null,
        var Telephone: String? = null,

    ) : Parcelable