package com.ahmadabuhasan.brightonrealestate.data.models

import com.google.gson.annotations.SerializedName

data class DetailModel(

    @SerializedName("Title")
    val title: String?,

    @SerializedName("Released")
    val released: String?,

    @SerializedName("Runtime")
    val runtime: String?,

    @SerializedName("Genre")
    val genre: String?,

    @SerializedName("Director")
    val director: String?,

    @SerializedName("Actors")
    val actors: String?,

    @SerializedName("Plot")
    val plot: String?,

    @SerializedName("Poster")
    val poster: String?,

    @SerializedName("imdbRating")
    val imdbRating: String?,
)
