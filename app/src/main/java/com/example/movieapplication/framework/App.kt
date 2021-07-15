
package com.example.movieapplication.framework

import android.app.Application
import androidx.room.Room
import com.example.movieapplication.model.database.HistoryDao
import com.example.movieapplication.model.database.HistoryDataBase

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {

        lateinit var appInstance: App

    }
}







