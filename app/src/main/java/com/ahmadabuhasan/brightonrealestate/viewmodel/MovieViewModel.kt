package com.ahmadabuhasan.brightonrealestate.viewmodel

import androidx.lifecycle.ViewModel
import com.ahmadabuhasan.brightonrealestate.data.repository.Repository

class MovieViewModel(private val repository: Repository) : ViewModel() {

    fun getSearch(search: String) =
        repository.getSearch(search)

    fun getByID(id: String) = repository.getByID(id)
}