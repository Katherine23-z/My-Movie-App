package com.example.movieapplication.model

import com.example.movieapplication.model.Movie

interface Repository {

    fun getMovieFromServer(id: Long) : Movie
    fun getMovieFromLocalStorageHorrors() : List<Movie>
    fun getMovieFromLocalStorageThrillers() : List<Movie>
    fun getMovieFromLocalStorageComedies() : List<Movie>
    fun getMovieFromLocalStorageSerials() : List<Movie>
    fun getMovieFromLocalStorageDefault() : List<Movie>

}