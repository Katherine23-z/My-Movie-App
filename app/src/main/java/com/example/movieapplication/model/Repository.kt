package com.example.movieapplication.model

import com.example.movieapplication.model.Movie

interface Repository {

    fun getMovieFromServer() : Movie
    fun getMovieFromLocalStorage() : Movie

}