package com.example.movieapplication.model.repository

import com.example.movieapplication.model.Movie
import com.example.movieapplication.model.database.HistoryEntity

interface LocalRepository {
    fun getAllHistory(): List<Movie>
    fun saveEntity(movie: Movie)
}