package com.example.vinhexample.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vinhexample.model.Feed
import com.example.vinhexample.repository.HomeRepository
import com.example.vinhexample.vo.Resource
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {

    val feedLiveData = MediatorLiveData<ArrayList<Feed>?>()

    val errorLiveData = MutableLiveData<Pair<String, Int?>>()

    fun getFeeds() {
        viewModelScope.launch {
            feedLiveData.addSource(repository.getFeeds()) {
                when (it) {
                    is Resource.Success -> {
                        feedLiveData.value = it.data
                    }
                    is Resource.Error -> {
                        errorLiveData.value = Pair(it.message, it.code)
                    }
                }
            }
        }
    }
}