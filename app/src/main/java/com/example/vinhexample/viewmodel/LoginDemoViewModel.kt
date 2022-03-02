package com.example.vinhexample.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.example.vinhexample.base.BaseViewModel
import com.example.vinhexample.model.User
import com.example.vinhexample.param.LoginDemoParam
import com.example.vinhexample.repository.LoginDemoRepository
import com.example.vinhexample.vo.Resource
import kotlinx.coroutines.launch

class LoginDemoViewModel(private val repository: LoginDemoRepository) : BaseViewModel() {

    val loginLiveData = MediatorLiveData<User?>()

    fun login(param: LoginDemoParam) {
        viewModelScope.launch {
            loginLiveData.addSource(repository.login(param)) {
                when (it) {
                    is Resource.Success -> {
                        loginLiveData.value = it.data
                    }
                    is Resource.Error -> {
                        networkError.value = Pair(it.message, it.code)
                    }
                }
            }
        }
    }
}