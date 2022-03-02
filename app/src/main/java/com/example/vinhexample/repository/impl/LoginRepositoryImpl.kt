package com.example.vinhexample.repository.impl

import androidx.lifecycle.LiveData
import com.example.vinhexample.api.ApiService
import com.example.vinhexample.data.remote.ReliaNetworkBoundResource
import com.example.vinhexample.model.LoginResponse
import com.example.vinhexample.param.LoginParam
import com.example.vinhexample.repository.LoginRepository
import com.example.vinhexample.vo.ReliaResource
import retrofit2.Response

class LoginRepositoryImpl(val api: ApiService) : LoginRepository {

    override suspend fun login(param: LoginParam): LiveData<ReliaResource<LoginResponse>> {
        return object : ReliaNetworkBoundResource<LoginResponse>() {
            override suspend fun createCall(): Response<LoginResponse> = api.login(param)

        }.build().asLiveData()
    }

}