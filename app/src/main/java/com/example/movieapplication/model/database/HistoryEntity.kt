package com.example.movieapplication.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true) val id : Long,
    val movieId: Long?,
    val title: String?,
    val genre: String?,
    val release: Int?
)
