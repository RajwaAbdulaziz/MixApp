package com.tuwaiq.mixapp.imdb.models

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: String = "",
    val rank: String = "",
    val title: String = "",
    val year: String = "",
    @SerializedName("im:age")
    val image_url: String = "",
    val crew: String = "",
    val imdbRating: String = ""
)