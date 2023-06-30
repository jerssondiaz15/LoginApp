package com.jersson.loginapp.presentation.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jersson.loginapp.presentation.ui.init.InitScreen
import com.jersson.loginapp.presentation.ui.list.ListScreen
import com.jersson.loginapp.presentation.ui.login.LogInScreen
import com.jersson.loginapp.presentation.ui.model.LoginState
import com.jersson.loginapp.presentation.ui.signup.SignUpScreen

fun NavGraphBuilder.loginGraph(
    state: () -> LoginState
) {
    navigation(
        startDestination = LoginNavigation.InitScreen.route,
        route = "login_screen"
    ) {
        composable(
            route = LoginNavigation.InitScreen.route
        ){
            InitScreen(
                state = state()
            )
        }
        composable(
            route = LoginNavigation.SignUpScreen.route
        ){
            SignUpScreen(
                state = state()
            )
        }
        composable(
            route = LoginNavigation.LogInScreen.route
        ){
            LogInScreen(
                state = state()
            )
        }
        composable(
            route = LoginNavigation.ListScreen.route
        ){
            ListScreen(
                state = state()
            )
        }
    }
}