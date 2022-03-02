package com.example.vinhexample.repository.impl

import androidx.lifecycle.LiveData
import com.example.vinhexample.api.ApiService
import com.example.vinhexample.data.remote.NetworkBoundResource
import com.example.vinhexample.model.ObjectResponse
import com.example.vinhexample.model.User
import com.example.vinhexample.param.LoginParam
import com.example.vinhexample.repository.LoginRepository
import com.example.vinhexample.vo.Resource
import retrofit2.Response

class LoginRepositoryImpl(val api: ApiService) : LoginRepository {

    override suspend fun login(param: LoginParam): LiveData<Resource<User>> {
        return object : NetworkBoundResource<ObjectResponse<User>, User>() {
            override suspend fun createCall(): Response<ObjectResponse<User>> = api.login(param)

            override fun processResponse(response: ObjectResponse<User>): User? = response.data
        }.build().asLiveData()
    }
}