package com.jersson.loginapp.data.users.remote.model

import com.google.gson.annotations.SerializedName

data class UserRequest(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("email") val email: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("first_name") val firstName: String = "",
    @SerializedName("last_name") val lastName: String = "",
    @SerializedName("avatar") val avatar: String = "",
    @SerializedName("password") val password: String = ""
)