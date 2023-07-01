package com.jersson.loginapp.data.users.local.model.mapper

import com.jersson.loginapp.data.users.local.model.DbUser
import com.jersson.loginapp.domain.model.User

fun List<DbUser>.toListUser():List<User> = this.map { it.toUser() }

fun DbUser.toUser(): User = with(this){
    User(
        id = id,
        email = email,
        firstName = firstName,
        lastName = lastName,
        avatar = avatar
    )
}

fun User.toDbUser(): DbUser = with(this){
    DbUser(
        id = id ?: 0,
        email = email,
        firstName = firstName,
        lastName = lastName,
        avatar = avatar
    )
}