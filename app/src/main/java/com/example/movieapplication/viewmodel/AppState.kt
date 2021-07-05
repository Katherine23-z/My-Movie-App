package com.example.movieapplication.viewmodel

import com.example.movieapplication.model.Movie

sealed class AppState {
    data class Success(val movieData: List<Movie>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()

}