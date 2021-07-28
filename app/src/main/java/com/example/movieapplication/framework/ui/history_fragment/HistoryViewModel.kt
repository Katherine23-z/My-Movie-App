package com.example.movieapplication.framework.ui.history_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//import com.example.movieapplication.framework.App.Companion.getHistoryDao
import com.example.movieapplication.model.database.HistoryDataBase
import com.example.movieapplication.model.repository.LocalRepository
import com.example.movieapplication.model.repository.LocalRepositoryImpl
import com.example.movieapplication.model.repository.Repository
import com.example.movieapplication.model.repository.RepositoryImpl
import com.example.movieapplication.viewmodel.AppState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class HistoryViewModel(val historyLiveData: MutableLiveData<AppState> = MutableLiveData(),
                       private val historyRepository: LocalRepository = LocalRepositoryImpl(HistoryDataBase.db.historyDao())
)
    : ViewModel(), CoroutineScope by  MainScope() {

        fun getAllHistory(){
            historyLiveData.value = AppState.Loading
            launch(Dispatchers.IO) {
                historyLiveData.postValue(AppState.Success(historyRepository.getAllHistory()))
            }
        }

}