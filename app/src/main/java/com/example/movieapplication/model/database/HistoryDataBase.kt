package com.example.movieapplication.model.database

import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieapplication.framework.App

@androidx.room.Database(
    entities = [
        HistoryEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class HistoryDataBase : RoomDatabase(){
    abstract fun historyDao(): HistoryDao

    companion object{
        private const val DB_NAME = "History.db"
        val db: HistoryDataBase by lazy{
            Room.databaseBuilder(App.appInstance, HistoryDataBase::class.java, DB_NAME).build()
        }
    }

}