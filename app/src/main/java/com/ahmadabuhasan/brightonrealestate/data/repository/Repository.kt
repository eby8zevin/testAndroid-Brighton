package com.ahmadabuhasan.brightonrealestate.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.ahmadabuhasan.brightonrealestate.data.api.ApiService
import com.ahmadabuhasan.brightonrealestate.data.models.DetailModel
import com.ahmadabuhasan.brightonrealestate.data.models.SearchModel

class Repository(private val apiService: ApiService) {

    fun getSearch(
        search: String?,
    ): LiveData<Result<SearchModel>> = liveData {
        emit(Result.Loading)
        try {
            val response = apiService.getSearch(apiKey, search)
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
            Log.e(TAG, "getSearch : ${e.message.toString()}")
        }
    }

    fun getByID(
        id: String?,
    ): LiveData<Result<DetailModel>> = liveData {
        emit(Result.Loading)
        try {
            val response = apiService.getByID(apiKey, id)
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
            Log.e(TAG, "getSearch : ${e.message.toString()}")
        }
    }

    companion object {
        private const val TAG = "Repository"
        private const val apiKey = "d9cb0f87"
    }
}