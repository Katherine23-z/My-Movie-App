package com.example.movieapplication.model.rest

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieAPI {
    @GET("movie")
    fun getMovie(
        @Query("id") id: Long
    ) : Response<MovieDTO>
}