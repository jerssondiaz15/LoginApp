package com.jersson.loginapp.data.users.remote

import com.jersson.loginapp.data.users.remote.model.mapper.toListUser
import com.jersson.loginapp.data.users.remote.model.mapper.toUserRequest
import com.jersson.loginapp.data.users.remote.network.UserService
import com.jersson.loginapp.domain.model.ResponseApi
import com.jersson.loginapp.domain.model.User
import javax.inject.Inject

class UserRemoteRepository @Inject constructor(
    private val api: UserService
) {

    suspend fun getListUsers(): List<User>?{
        return api.getListUsers()?.listUsers?.toListUser()
    }

    suspend fun createUser(user: User): ResponseApi {
        return api.createUser(user.toUserRequest())
    }

    suspend fun loginUser(user: User): ResponseApi {
        return api.loginUser(user.toUserRequest())
    }
}