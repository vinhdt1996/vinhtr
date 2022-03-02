package com.example.vinhexample.repository.impl

import androidx.lifecycle.LiveData
import com.example.vinhexample.api.ApiService
import com.example.vinhexample.data.remote.ReliaNetworkBoundResource
import com.example.vinhexample.model.RegisterResponse
import com.example.vinhexample.param.RegisterParam
import com.example.vinhexample.repository.RegisterRepository
import com.example.vinhexample.vo.ReliaResource
import retrofit2.Response

class RegisterRepositoryImpl(val api: ApiService) : RegisterRepository {

    override suspend fun register(param: RegisterParam): LiveData<ReliaResource<RegisterResponse>> {
        return object : ReliaNetworkBoundResource<RegisterResponse>() {
            override suspend fun createCall(): Response<RegisterResponse> = api.register(param)

        }.build().asLiveData()
    }

}