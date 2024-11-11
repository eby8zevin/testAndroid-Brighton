package com.ahmadabuhasan.brightonrealestate.data.models

import com.google.gson.annotations.SerializedName

data class SearchModel(

    @SerializedName("Search")
    val search: MutableList<ListModel>,
)