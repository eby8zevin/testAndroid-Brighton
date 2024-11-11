package com.ahmadabuhasan.brightonrealestate.data.models

import com.google.gson.annotations.SerializedName

data class ListModel(

    @SerializedName("Title")
    val title: String?,

    @SerializedName("Year")
    val year: String?,

    @SerializedName("imdbID")
    val imdbID: String?,

    @SerializedName("Type")
    val type: String?,

    @SerializedName("Poster")
    val poster: String?,
)
