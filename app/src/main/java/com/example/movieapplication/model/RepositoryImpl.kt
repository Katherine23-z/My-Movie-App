package com.example.movieapplication.model

class RepositoryImpl : Repository {
    override fun getMovieFromServer(): Movie {
        return Movie()
    }

    override fun getMovieFromLocalStorageHorrors(): List<Movie> {
        return getHorrorMovies()
    }

    override fun getMovieFromLocalStorageThrillers(): List<Movie> {
       return getThrillerMovies()
    }

    override fun getMovieFromLocalStorageComedies(): List<Movie> {
        return getComedyMovies()
    }

    override fun getMovieFromLocalStorageSerials(): List<Movie> {
        return getSerials()
    }

    override fun getMovieFromLocalStorageDefault(): List<Movie> {
        return getDefault()
    }

}