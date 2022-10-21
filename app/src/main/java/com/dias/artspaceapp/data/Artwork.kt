package com.dias.artspaceapp.data

import androidx.annotation.DrawableRes

data class Artwork(
    val title: String,
    val artist: String,
    val year: Int,
    @DrawableRes val imageId: Int,
)
