package com.jersson.loginapp.presentation.ui.model

data class LoginState(
    val loginData: LoginData = LoginData(),
    val loginFunctions: LoginFunctions = LoginFunctions(),
    val loginNavigation: LoginNavigation = LoginNavigation()
) {
    data class LoginData(
        val email: String = "",
        val name: String = "Jersson Diaz",
        val password: String = ""
    )

    data class LoginFunctions(
        val updateData: ((LoginData) -> Unit)? = null,
    )

    data class LoginNavigation(
        val back: (() -> Unit)? = null,
        val signUp: (() -> Unit)? = null,
        val logIn: (() -> Unit)? = null,
        val list: (() -> Unit)? = null
    )
}