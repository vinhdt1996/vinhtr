package com.example.vinhexample.di

import com.example.vinhexample.viewmodel.HomeViewModel
import com.example.vinhexample.viewmodel.LoginDemoViewModel
import com.example.vinhexample.viewmodel.LoginViewModel
import com.example.vinhexample.viewmodel.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { LoginDemoViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { LoginViewModel(get()) }
}