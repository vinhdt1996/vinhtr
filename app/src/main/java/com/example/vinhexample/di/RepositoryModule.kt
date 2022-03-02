package com.example.vinhexample.di

import com.example.vinhexample.repository.HomeRepository
import com.example.vinhexample.repository.LoginDemoRepository
import com.example.vinhexample.repository.LoginRepository
import com.example.vinhexample.repository.RegisterRepository
import com.example.vinhexample.repository.impl.HomeRepositoryImpl
import com.example.vinhexample.repository.impl.LoginDemoRepositoryImpl
import com.example.vinhexample.repository.impl.LoginRepositoryImpl
import com.example.vinhexample.repository.impl.RegisterRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<LoginDemoRepository> { LoginDemoRepositoryImpl(get()) }
    single<HomeRepository> { HomeRepositoryImpl(get()) }
    single<RegisterRepository> { RegisterRepositoryImpl(get()) }
    single<LoginRepository> { LoginRepositoryImpl(get()) }
}