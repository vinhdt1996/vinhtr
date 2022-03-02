package com.example.vinhexample.api

import com.example.vinhexample.constant.Constant
import com.example.vinhexample.constant.Constant.ITEM_PER_PAGE
import com.example.vinhexample.model.*
import com.example.vinhexample.param.LoginDemoParam
import com.example.vinhexample.param.LoginParam
import com.example.vinhexample.param.RegisterParam
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("users-login")
    suspend fun loginDemo(@Body param: LoginDemoParam): Response<ObjectResponse<User>>

    @GET("search-user")
    suspend fun getUsers(
        @Query("page") page: Int = 1,
        @Query("current_per_page") perPage: Int = ITEM_PER_PAGE
    ): Response<ListResponse<User>>

    @GET("feed")
    suspend fun getFeeds(
        @Query("page") page: Int = 1,
        @Query("current_per_page") perPage: Int = ITEM_PER_PAGE
    ): Response<ListResponse<Feed>>

    @POST(Constant.EndPoint.REGISTER)
    suspend fun register(@Body param: RegisterParam): Response<RegisterResponse>

    @POST(Constant.EndPoint.AUTH_LOGIN)
    suspend fun login(@Body param: LoginParam): Response<LoginResponse>
}