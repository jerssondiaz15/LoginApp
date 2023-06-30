package com.jersson.loginapp.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jersson.loginapp.presentation.ui.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginNavHost(
    viewModel: LoginViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    LaunchedEffect(key1 = null) {
        viewModel.events.collect {
            when (it) {
                LoginViewModel.UIEvents.SignUp -> {
                    navController.navigate(LoginNavigation.SignUpScreen.route){
                        popUpTo(LoginNavigation.InitScreen.route)
                    }
                }
                LoginViewModel.UIEvents.LogIn -> {
                    navController.navigate(LoginNavigation.LogInScreen.route){
                        popUpTo(LoginNavigation.InitScreen.route)
                    }
                }
                LoginViewModel.UIEvents.List -> {
                    navController.navigate(LoginNavigation.ListScreen.route){
                        popUpTo(LoginNavigation.InitScreen.route)
                    }
                }
            }
        }
    }

    Scaffold {
        NavHost(
            navController = navController,
            startDestination = "login_screen"
        ) {
            loginGraph(
                state = {
                    viewModel.state.value
                }
            )
        }
    }
}