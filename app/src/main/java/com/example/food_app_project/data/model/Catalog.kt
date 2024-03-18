package com.example.food_app_project.data.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Catalog(
    var category: String,
    var name: String,
    var description: String,
    var price: Double,
    var location: String,
    @DrawableRes
    var image: Int
): Parcelable
