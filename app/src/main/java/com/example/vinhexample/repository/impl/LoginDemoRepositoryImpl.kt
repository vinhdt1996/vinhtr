package com.example.vinhexample.repository.impl

import androidx.lifecycle.LiveData
import com.example.vinhexample.api.ApiService
import com.example.vinhexample.data.remote.NetworkBoundResource
import com.example.vinhexample.model.ObjectResponse
import com.example.vinhexample.model.User
import com.example.vinhexample.param.LoginDemoParam
import com.example.vinhexample.repository.LoginDemoRepository
import com.example.vinhexample.vo.Resource
import retrofit2.Response

class LoginDemoRepositoryImpl(val api: ApiService) : LoginDemoRepository {

    override suspend fun login(param: LoginDemoParam): LiveData<Resource<User>> {
        return object : NetworkBoundResource<ObjectResponse<User>, User>() {
            override suspend fun createCall(): Response<ObjectResponse<User>> = api.loginDemo(param)

            override fun processResponse(response: ObjectResponse<User>): User? = response.data
        }.build().asLiveData()
    }
}