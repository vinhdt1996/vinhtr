package com.example.vinhexample.repository

import androidx.lifecycle.LiveData
import com.example.vinhexample.model.LoginResponse
import com.example.vinhexample.param.LoginParam
import com.example.vinhexample.vo.ReliaResource

interface LoginRepository {
    suspend fun login(param: LoginParam): LiveData<ReliaResource<LoginResponse>>

}