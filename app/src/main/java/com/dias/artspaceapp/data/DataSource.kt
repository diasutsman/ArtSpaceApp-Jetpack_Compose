package com.dias.artspaceapp.data

import com.dias.artspaceapp.R

object DataSource {
    val artworks = listOf(
        Artwork(
            title = "The Starry Night",
            artist = "Vincent van Gogh",
            year = 1889,
            imageId = R.drawable.starry_night
        ),
        Artwork(
            title = "The Persistence of Memory",
            artist = "Salvador Dalí",
            year = 1931,
            imageId = R.drawable.persistence_of_memory
        ),
        Artwork(
            title = "The Scream",
            artist = "Edvard Munch",
            year = 1893,
            imageId = R.drawable.the_scream
        ),
    )
}