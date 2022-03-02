package com.example.vinhexample.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.example.vinhexample.base.BaseViewModel
import com.example.vinhexample.model.LoginResponse
import com.example.vinhexample.param.LoginParam
import com.example.vinhexample.repository.LoginRepository
import com.example.vinhexample.vo.ReliaResource
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LoginRepository) : BaseViewModel() {

    val loginLiveData = MediatorLiveData<LoginResponse?>()

    fun login(param: LoginParam) {
        viewModelScope.launch {
            loginLiveData.addSource(repository.login(param)) { resource ->
                when (resource) {
                    is ReliaResource.Success -> {
                        resource.data?.let {
                            loginLiveData.value = it
                        }
                    }
                    is ReliaResource.Error -> Unit
                }
            }
        }
    }
}