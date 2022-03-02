package com.example.vinhexample.repository

import androidx.lifecycle.LiveData
import com.example.vinhexample.model.User
import com.example.vinhexample.param.LoginParam
import com.example.vinhexample.vo.Resource

interface LoginRepository {
    suspend fun login(param: LoginParam): LiveData<Resource<User>>
}