package com.jersson.loginapp.presentation.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jersson.loginapp.presentation.ui.model.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor():ViewModel(){

    private var _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    private var _events = MutableSharedFlow<UIEvents>()
    val events: SharedFlow<UIEvents> = _events

    init {
        _state.value = state.value.copy(
            loginFunctions = state.value.loginFunctions.copy(
                updateData = ::updateData
            ),
            loginNavigation = state.value.loginNavigation.copy(
                signUp = ::signUp,
                logIn = ::logIn,
                list = ::list
            )
        )
    }

    private fun updateData(loginData: LoginState.LoginData){
        _state.value = state.value.copy(
            loginData = loginData
        )
    }

    private fun signUp(){
        viewModelScope.launch {
            _events.emit(
                UIEvents.SignUp
            )
        }
    }

    private fun logIn(){
        viewModelScope.launch {
            _events.emit(
                UIEvents.LogIn
            )
        }
    }

    private fun list(){
        viewModelScope.launch {
            _events.emit(
                UIEvents.List
            )
        }
    }

    sealed class UIEvents {
        object SignUp : UIEvents()
        object LogIn : UIEvents()
        object List : UIEvents()
    }
}