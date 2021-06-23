package com.example.movieapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapplication.model.Repository
import com.example.movieapplication.model.RepositoryImpl
import java.lang.Thread.sleep

const val TIME = 2000
class MainViewModel(private val liveDataToObserve: MutableLiveData<Any> = MutableLiveData(),
                    private val repositoryImpl: Repository = RepositoryImpl()) : ViewModel() {

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