package com.bibitdev.submissionandroidbegineerapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    val name : String,
    val description : String,
    val photo : Int
) : Parcelable
