package com.example.movieapplication.model.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.movieapplication.model.*
import com.example.movieapplication.model.rest.MovieRepo
import retrofit2.http.GET

class RepositoryImpl : Repository {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun getMovieFromServer(id: Long): Movie {
        val dto = MovieRepo.api.getMovie(id).body()
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