package com.example.movieapplication.model

data class Movie(val movieTitle: String = getDefaultTitle(), val movieGenre: String= getDefaultGenre(), val yearOfRelease: Int = 0, val movieDuration: Int = 0) {
}

fun getDefaultGenre() = "Жанр"

fun getDefaultTitle() = "Название фильма"
