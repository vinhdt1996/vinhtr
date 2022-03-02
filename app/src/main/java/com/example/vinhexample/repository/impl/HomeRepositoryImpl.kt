package com.example.vinhexample.repository.impl

import androidx.lifecycle.LiveData
import com.example.vinhexample.api.ApiService
import com.example.vinhexample.data.remote.NetworkBoundResource
import com.example.vinhexample.model.Feed
import com.example.vinhexample.model.ListResponse
import com.example.vinhexample.repository.HomeRepository
import com.example.vinhexample.vo.Resource
import retrofit2.Response

class HomeRepositoryImpl(val api: ApiService): HomeRepository {
    override suspend fun getFeeds(): LiveData<Resource<ArrayList<Feed>>> {
        return object : NetworkBoundResource<ListResponse<Feed>, ArrayList<Feed>>() {
            override suspend fun createCall(): Response<ListResponse<Feed>> = api.getFeeds()

            override fun processResponse(response: ListResponse<Feed>): ArrayList<Feed>? = response.data
        }.build().asLiveData()
    }
}