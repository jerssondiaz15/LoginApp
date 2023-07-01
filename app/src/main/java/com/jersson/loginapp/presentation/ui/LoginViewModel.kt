package com.jersson.loginapp.presentation.ui

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jersson.loginapp.R
import com.jersson.loginapp.domain.model.ResponseApi
import com.jersson.loginapp.domain.model.User
import com.jersson.loginapp.domain.usecase.CreateUserUseCase
import com.jersson.loginapp.domain.usecase.GetListUsersUseCase
import com.jersson.loginapp.domain.usecase.GetUserUseCase
import com.jersson.loginapp.domain.usecase.LoginUserUseCase
import com.jersson.loginapp.presentation.ui.model.LoginState
import com.jersson.loginapp.presentation.ui.utils.isValidEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    @ApplicationContext context: Context,
    private val getListUsersUseCase: GetListUsersUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val createUserUseCase: CreateUserUseCase,
    private val loginUserUseCase: LoginUserUseCase
):ViewModel(){

    private val resources = context.resources

    private var _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    private var _events = MutableSharedFlow<UIEvents>()
    val events: SharedFlow<UIEvents> = _events

    init {
        _state.value = state.value.copy(
            loginFunctions = state.value.loginFunctions.copy(
                updateData = ::updateData,
                findUser = ::findUser,
                createUser = ::createUser,
                loginUser = ::loginUser
            ),
            loginNavigation = state.value.loginNavigation.copy(
                list = ::list
            )
        )
        getList()
    }

    private fun getList(){
        viewModelScope.launch {
            val result = getListUsersUseCase.invoke()
            _state.value = state.value.copy(
                listUsers = result
            )
            Log.i("getListUsersUseCase: ", result.toString())
        }
    }

    private fun updateData(data: LoginState.Data){
        _state.value = state.value.copy(
            data = data
        )
    }

    private fun findUser(){
        viewModelScope.launch {
            val result = getUserUseCase.invoke(state.value.data.email)
            Log.i("getUserUseCase(${state.value.user.email!!}): ", result.toString())
            if (!state.value.data.email.isValidEmail()){
                _state.value = state.value.copy(
                    validateEmail = true
                )
            } else{
                _state.value = state.value.copy(
                    validateEmail = false
                )
                if (result == null){
                    _events.emit(
                        UIEvents.SignUp
                    )
                } else{
                    _state.value = state.value.copy(
                        user = result
                    )
                    _events.emit(
                        UIEvents.LogIn
                    )
                }
            }
        }
    }

    private fun createUser(){
        viewModelScope.launch {
            _state.value = state.value.copy(
                user = state.value.user.copy(
                    email = state.value.data.name,
                    password = state.value.data.password
                )
            )
            if (state.value.data.name.isEmpty()){
                _state.value = state.value.copy(
                    validateName = true,
                    errorTextSignUp = resources.getString(R.string.enter_a_name)
                )
            } else if (state.value.data.password.isEmpty()){
                _state.value = state.value.copy(
                    validateName = false,
                    validatePasswordSignup = true,
                    errorTextSignUp = resources.getString(R.string.enter_a_password)
                )
            } else{
                _state.value = state.value.copy(
                    validateName = false,
                    validatePasswordSignup = false,
                    errorTextSignUp = resources.getString(R.string.enter_a_password)
                )
                when(createUserUseCase.invoke(state.value.user)){
                    ResponseApi.ERROR -> {
                        Log.i("createUserUseCase: ", "Error")
                    }
                    ResponseApi.SUCCESS -> {
                        _events.emit(
                            UIEvents.List
                        )
                    }
                }
            }
        }
    }

    private fun loginUser(){
        viewModelScope.launch {
            _state.value = state.value.copy(
                user = state.value.user.copy(
                    email = state.value.data.email,
                    password = state.value.data.password
                )
            )
            if (state.value.data.password.isEmpty()){
                _state.value = state.value.copy(
                    validateName = true,
                    errorTextSignUp = resources.getString(R.string.enter_a_password)
                )
            } else{
                when(loginUserUseCase.invoke(state.value.user)){
                    ResponseApi.ERROR -> {
                        Log.i("loginUserUseCase: ", "Error")
                    }
                    ResponseApi.SUCCESS -> {
                        _events.emit(
                            UIEvents.List
                        )
                    }
                }
            }
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