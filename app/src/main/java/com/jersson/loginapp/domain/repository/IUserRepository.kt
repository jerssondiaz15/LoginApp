package com.jersson.loginapp.domain.repository

import com.jersson.loginapp.domain.model.User

interface IUserRepository {

    suspend fun getListDbUsers(): List<User>

    suspend fun deleteAllUsers()

    suspend fun insertUser(user: User)

    suspend fun getDbUser(email: String): User?
}