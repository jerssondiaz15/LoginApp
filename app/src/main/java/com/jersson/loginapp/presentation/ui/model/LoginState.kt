package com.jersson.loginapp.presentation.ui.model

import com.jersson.loginapp.domain.model.User

data class LoginState(
    val user: User = User(),
    val data: Data = Data(),
    val listUsers: List<User> = listOf(),
    val validateEmail: Boolean = false,
    val validateName: Boolean = false,
    val errorTextSignUp: String = "",
    val validatePasswordSignup: Boolean = false,
    val validatePasswordLogin: Boolean = false,
    val loginFunctions: LoginFunctions = LoginFunctions(),
    val loginNavigation: LoginNavigation = LoginNavigation()
) {

    data class LoginFunctions(
        val updateData: ((Data) -> Unit)? = null,
        val findUser: (() -> Unit)? = null,
        val createUser: (() -> Unit)? = null,
        val loginUser: (() -> Unit)? = null
    )

    data class Data(
        val email: String = "",
        val password: String = "",
        val name: String = ""
    )

    data class LoginNavigation(
        var back: (() -> Unit)? = null,
        val list: (() -> Unit)? = null
    )
}