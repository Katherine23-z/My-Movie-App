package com.example.movieapplication.model

import android.os.Build
import androidx.annotation.RequiresApi

class RepositoryImpl : Repository {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun getMovieFromServer(id: Long): Movie {
        val dto = MovieLoader.loadMovie(id)
        return Movie (
                overview = dto?.overview
        )
    }


    override fun getMovieFromLocalStorageHorrors() = getHorrorMovies()


    override fun getMovieFromLocalStorageThrillers() = getThrillerMovies()


    override fun getMovieFromLocalStorageComedies() = getComedyMovies()


    override fun getMovieFromLocalStorageSerials() = getSerials()


    override fun getMovieFromLocalStorageDefault() = getDefault()


}