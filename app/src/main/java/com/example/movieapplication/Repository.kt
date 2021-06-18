package com.example.movieapplication

object Repository {
    private val movieList: List<Movie>

    init {
        movieList = listOf(
            Movie("Prestige", "thriller", 2006, 130),
            Movie("It follows", "horror", 2014, 100),
            Movie("The silence of the Lambs", "thriller", 1991, 114)
        )
    }

    fun getMovieList(): List<Movie> {
        return movieList
    }

    fun getMovie(position: Int): Movie {
        return movieList[position]
    }

    fun size(): Int {
        return movieList.size
    }

}