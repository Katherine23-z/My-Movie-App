package com.example.movieapplication.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//import com.example.movieapplication.framework.App.Companion.getHistoryDao
import com.example.movieapplication.model.Movie
import com.example.movieapplication.model.database.HistoryDataBase
import com.example.movieapplication.model.repository.LocalRepository
import com.example.movieapplication.model.repository.LocalRepositoryImpl
import com.example.movieapplication.model.repository.Repository
import com.example.movieapplication.model.repository.RepositoryImpl
import kotlinx.coroutines.*

class MovieCardViewModel(val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
                         private val historyRepository: LocalRepository = LocalRepositoryImpl(
                             HistoryDataBase.db.historyDao()))
                         : ViewModel(), LifecycleObserver, CoroutineScope by MainScope() {

    fun saveMovieToDB(movie: Movie) {
        launch {
            async(Dispatchers.IO) {
                historyRepository.saveEntity(movie)
            }
        }
    }

}