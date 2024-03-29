package com.example.food_app_project.data.model

import androidx.annotation.DrawableRes
import java.util.UUID

data class Category (
    var id:String = UUID.randomUUID().toString(),
    @DrawableRes
    var image : Int,
    var name :String
)