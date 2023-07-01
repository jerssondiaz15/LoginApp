package com.jersson.loginapp.data.users.remote.model.mapper

import com.jersson.loginapp.data.users.remote.model.UserResponse
import com.jersson.loginapp.domain.model.User

fun List<UserResponse>.toListUser(): List<User> = this.map{ it.toUser() }

fun UserResponse.toUser(): User = with(this){
    User(
        id = id,
        email = email,
        firstName = firstName,
        lastName = lastName,
        avatar = avatar,
        token = token
    )
}