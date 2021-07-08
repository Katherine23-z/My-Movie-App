package com.example.movieapplication.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapplication.model.repository.Repository
import com.example.movieapplication.model.repository.RepositoryImpl
import kotlinx.coroutines.*

class MovieCardViewModel(private val repositoryImpl: Repository = RepositoryImpl()): ViewModel(), LifecycleObserver, CoroutineScope by MainScope() {
    val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()

    fun loadData(id: Long){
        liveDataToObserve.value = AppState.Loading
        launch {
            val job = async(Dispatchers.IO) {repositoryImpl.getMovieFromServer(id)  }
            liveDataToObserve.value = AppState.Success(listOf(job.await()))
        }
    }

}