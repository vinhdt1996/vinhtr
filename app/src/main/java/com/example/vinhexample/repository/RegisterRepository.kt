package com.example.vinhexample.repository

import androidx.lifecycle.LiveData
import com.example.vinhexample.model.RegisterResponse
import com.example.vinhexample.param.RegisterParam
import com.example.vinhexample.vo.ReliaResource

interface RegisterRepository {
    suspend fun register(param: RegisterParam): LiveData<ReliaResource<RegisterResponse>>

}