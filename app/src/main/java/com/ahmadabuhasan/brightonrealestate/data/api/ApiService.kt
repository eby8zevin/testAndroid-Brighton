package com.ahmadabuhasan.brightonrealestate.data.api

import com.ahmadabuhasan.brightonrealestate.data.models.DetailModel
import com.ahmadabuhasan.brightonrealestate.data.models.SearchModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/")
    suspend fun getSearch(
        @Query("apikey") apiKey: String?,
        @Query("s") search: String?,
    ): SearchModel

    @GET("/")
    suspend fun getByID(
        @Query("apikey") apiKey: String?,
        @Query("i") id: String?,
    ): DetailModel
}