package com.example.vinhexample.repository

import androidx.lifecycle.LiveData
import com.example.vinhexample.model.User
import com.example.vinhexample.param.LoginDemoParam
import com.example.vinhexample.vo.Resource

interface LoginDemoRepository {
    suspend fun login(param: LoginDemoParam): LiveData<Resource<User>>
}