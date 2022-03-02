package com.example.vinhexample.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.example.vinhexample.base.BaseViewModel
import com.example.vinhexample.model.RegisterResponse
import com.example.vinhexample.param.RegisterParam
import com.example.vinhexample.repository.RegisterRepository
import com.example.vinhexample.vo.ReliaResource
import kotlinx.coroutines.launch

class RegisterViewModel(private val repository: RegisterRepository) : BaseViewModel() {

    val registerLiveData = MediatorLiveData<RegisterResponse?>()

    fun register(param: RegisterParam) {
        viewModelScope.launch {
            registerLiveData.addSource(repository.register(param)) { resource ->
                when (resource) {
                    is ReliaResource.Success -> {
                        resource.data?.let {
                            if (it.success == true) {
                                registerLiveData.value = it
                            }
                        }
                    }
                    is ReliaResource.Error -> Unit
                }
            }
        }
    }
}