package com.jersson.loginapp.presentation.ui.navigation

sealed class LoginNavigation(val route: String) {
    object InitScreen : LoginNavigation("init_screen")
    object SignUpScreen : LoginNavigation("sign_up_screen")
    object LogInScreen : LoginNavigation("log_in_screen")
    object ListScreen : LoginNavigation("list_screen")
}
