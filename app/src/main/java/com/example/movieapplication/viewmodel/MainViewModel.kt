package com.example.movieapplication.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapplication.model.repository.Repository
import com.example.movieapplication.model.repository.RepositoryImpl
import kotlinx.coroutines.*
import java.lang.Thread.sleep

const val TIME = 2000
class MainViewModel(private val repositoryImpl: Repository = RepositoryImpl()): ViewModel(), LifecycleObserver, CoroutineScope by MainScope(){
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()

    fun getLiveData() = liveDataToObserve

    fun getDataFromLocalSourceHorrors() = getDataFromLocalSource(movieGenre = "horror")
    fun getDataFromLocalSourceThrillers() = getDataFromLocalSource(movieGenre = "thriller")
    fun getDataFromLocalSourceComedies() = getDataFromLocalSource(movieGenre = "comedy")
    fun getDataFromLocalSourceSerials() = getDataFromLocalSource(movieGenre = "serial")

    private fun getDataFromLocalSource(movieGenre: String) {
        liveDataToObserve.value = AppState.Loading

        Thread {
            sleep(TIME.toLong())
            liveDataToObserve.postValue(AppState.Success(
                    when(movieGenre){
                        "horror" -> repositoryImpl.getMovieFromLocalStorageHorrors()
                        "thriller" -> repositoryImpl.getMovieFromLocalStorageThrillers()
                        "comedy" -> repositoryImpl.getMovieFromLocalStorageComedies()
                        "serial"-> repositoryImpl.getMovieFromLocalStorageSerials()
                        else -> repositoryImpl.getMovieFromLocalStorageDefault()
                    }
            ))
        }.start()

    }

}