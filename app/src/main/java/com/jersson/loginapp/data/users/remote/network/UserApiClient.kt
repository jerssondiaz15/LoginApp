package com.jersson.loginapp.data.users.remote.network

import com.jersson.loginapp.data.users.remote.model.ListUsersResponse
import com.jersson.loginapp.data.users.remote.model.UserRequest
import com.jersson.loginapp.data.users.remote.model.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApiClient {

    @GET("users")
    suspend fun getListUsers(): Response<ListUsersResponse>

    @POST("register")
    suspend fun createUser(
        @Body user: UserRequest
    ): Response<UserResponse>

    @POST("login")
    suspend fun loginUser(
        @Body user: UserRequest
    ): Response<UserResponse>
}