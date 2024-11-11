package com.ahmadabuhasan.brightonrealestate.di

import android.content.Context
import com.ahmadabuhasan.brightonrealestate.data.api.ApiConfig
import com.ahmadabuhasan.brightonrealestate.data.repository.Repository

object Injection {
    fun provideRepository(context: Context): Repository {
        val apiService = ApiConfig.getApiService(context)
        return Repository(apiService)
    }
}