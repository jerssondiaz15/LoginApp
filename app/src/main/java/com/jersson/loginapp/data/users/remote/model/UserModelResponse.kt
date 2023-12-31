package com.jersson.loginapp.data.users.remote.model

import com.google.gson.annotations.SerializedName

data class ListUsersResponse(
    @SerializedName("data") val listUsers: List<UserResponse> = emptyList(),
)

data class UserResponse(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("email") val email: String = "",
    @SerializedName("first_name") val firstName: String = "",
    @SerializedName("last_name") val lastName: String = "",
    @SerializedName("avatar") val avatar: String = "",
    @SerializedName("token") val token: String = ""
)