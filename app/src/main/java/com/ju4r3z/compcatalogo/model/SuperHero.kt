package com.ju4r3z.compcatalogo.model

import androidx.annotation.DrawableRes

data class SuperHero(
    var name: String,
    val realName: String,
    var publisher: String,
    @DrawableRes var photo: Int
)
