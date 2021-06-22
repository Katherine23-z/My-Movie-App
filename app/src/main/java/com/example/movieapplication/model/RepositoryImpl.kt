package com.example.movieapplication.model

class RepositoryImpl : Repository {
    override fun getMovieFromServer() = Movie()

    override fun getMovieFromLocalStorageHorrors() = getHorrorMovies()


    override fun getMovieFromLocalStorageThrillers() = getThrillerMovies()


    override fun getMovieFromLocalStorageComedies() = getComedyMovies()


    override fun getMovieFromLocalStorageSerials() = getSerials()


    override fun getMovieFromLocalStorageDefault() = getDefault()


}