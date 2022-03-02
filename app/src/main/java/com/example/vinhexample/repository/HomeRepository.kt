package com.example.vinhexample.repository

import androidx.lifecycle.LiveData
import com.example.vinhexample.model.Feed
import com.example.vinhexample.vo.Resource

interface HomeRepository {
    suspend fun getFeeds(): LiveData<Resource<ArrayList<Feed>>>
}