package com.jersson.loginapp.domain.model

data class User(
    val id: Int? = 0,
    val email: String? = "",
    val firstName: String? = "",
    val lastName: String? = "",
    val avatar: String? = "",
    val password: String? = "",
    val token: String? = ""
)