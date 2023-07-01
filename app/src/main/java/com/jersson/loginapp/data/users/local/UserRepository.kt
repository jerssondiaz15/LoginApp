package com.jersson.loginapp.data.users.local

import com.jersson.loginapp.data.users.local.datasource.UserDatabaseDataSource
import com.jersson.loginapp.data.users.local.model.mapper.toDbUser
import com.jersson.loginapp.data.users.local.model.mapper.toListUser
import com.jersson.loginapp.data.users.local.model.mapper.toUser
import com.jersson.loginapp.domain.model.User
import com.jersson.loginapp.domain.repository.IUserRepository
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDatabaseDataSource: UserDatabaseDataSource
): IUserRepository {

    override suspend fun getListDbUsers(): List<User> {
        return userDatabaseDataSource.getListDbUsers().toListUser()
    }

    override suspend fun deleteAllUsers() {
        userDatabaseDataSource.deleteAllUsers()
    }

    override suspend fun insertUser(user: User) {
        userDatabaseDataSource.insertUser(user.toDbUser())
    }

    override suspend fun getDbUser(email: String): User? {
        val response = userDatabaseDataSource.getDbUser(email)
        return response?.toUser()
    }

}