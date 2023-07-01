package com.jersson.loginapp.data.users.remote.model.mapper

import com.jersson.loginapp.data.users.remote.model.UserRequest
import com.jersson.loginapp.domain.model.User

fun User.toUserRequest(): UserRequest = with(this){
    UserRequest(
        id = id ?: 0,
        email = email ?: "",
        name = "$firstName $lastName",
        firstName = firstName ?: "",
        lastName = lastName ?: "",
        avatar = avatar ?: "",
        password = password ?: ""
    )
}