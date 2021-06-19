package com.example.movieapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(val movieTitle: String = getDefaultTitle(), val movieGenre: String= getDefaultGenre(), val yearOfRelease: Int = 0, val movieDuration: Int = 0)
        : Parcelable{
}

fun getDefaultGenre() = "Жанр"

fun getDefaultTitle() = "Название фильма"

fun getHorrorMovies() : MutableList<Movie>{
    return mutableListOf(
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0)
    )
}

fun getThrillerMovies() : MutableList<Movie>{
    return mutableListOf(
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0)
    )
}

fun getComedyMovies() : MutableList<Movie>{
    return mutableListOf(
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0),
            Movie("", "", 0,0)
    )
}

fun getSerials() : MutableList<Movie> {
    return mutableListOf(
            Movie("", "", 0, 0),
            Movie("", "", 0, 0),
            Movie("", "", 0, 0),
            Movie("", "", 0, 0),
            Movie("", "", 0, 0),
            Movie("", "", 0, 0),
            Movie("", "", 0, 0),
            Movie("", "", 0, 0),
            Movie("", "", 0, 0),
            Movie("", "", 0, 0),
            Movie("", "", 0, 0),
            Movie("", "", 0, 0)
    )
}

    fun getDefault() : MutableList<Movie>{
        return mutableListOf(
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0),
                Movie("", "", 0,0)
        )
}
