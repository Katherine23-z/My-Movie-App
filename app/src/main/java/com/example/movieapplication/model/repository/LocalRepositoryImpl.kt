package com.example.movieapplication.model.repository

import com.example.movieapplication.model.Movie
import com.example.movieapplication.model.database.HistoryDao
import com.example.movieapplication.model.database.HistoryDataBase
import com.example.movieapplication.model.database.HistoryEntity

class LocalRepositoryImpl(private val localDataSource: HistoryDao = HistoryDataBase.db.historyDao()) : LocalRepository {

    override fun getAllHistory(): List<Movie> {
        return convertHistoryEntityToMovie(localDataSource.all())
    }

    override fun saveEntity(movie: Movie) {
        localDataSource.insert(convertMovieToEntity(movie))
    }

    fun convertHistoryEntityToMovie(entityList: List<HistoryEntity>): List<Movie>{
        return entityList.map { Movie(it.movieId, it.title, it.genre, it.release) }
    }

    fun convertMovieToEntity(movie: Movie): HistoryEntity{
        return HistoryEntity(0, movie.movieId, movie.movieTitle, movie.movieGenre, movie.yearOfRelease)
    }
}