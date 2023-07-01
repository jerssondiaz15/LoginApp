package com.jersson.loginapp.presentation.ui.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jersson.loginapp.R
import com.jersson.loginapp.presentation.ui.commons.UserItem
import com.jersson.loginapp.presentation.ui.components.CustomButton
import com.jersson.loginapp.presentation.ui.model.LoginState
import com.jersson.loginapp.presentation.ui.theme.*

@Composable
fun LogInScreen(
    state: LoginState = LoginState()
) {

    var passwordVisibility: Boolean by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            IconButton(
                onClick = {
                    state.loginNavigation.back?.invoke()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(7f)
        ){
            Text(
                modifier = Modifier
                    .padding(
                        horizontal = 30.dp,
                        vertical = 16.dp
                    ),
                text = stringResource(id = R.string.log_in),
                style = tittle
            )
            Box(
                modifier = Modifier
                    .padding(
                        vertical = 16.dp,
                        horizontal = 4.dp
                    )
                    .background(
                        color = SnackbarDefaults.backgroundColor.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .padding(26.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    UserItem(user = state.user)
                    Spacer(modifier = Modifier.height(16.dp))
                    AnimatedVisibility(visible = state.validatePasswordLogin) {
                        Text(
                            textAlign = TextAlign.Center,
                            style = typeErrorTitle,
                            text = stringResource(id = R.string.enter_a_password)
                        )
                    }
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = state.data.password,
                        onValueChange = {
                            state.loginFunctions.updateData?.invoke(
                                state.data.copy(
                                    password = it
                                )
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = colorGreen,
                            unfocusedBorderColor = Color.White,
                            backgroundColor = Color.White
                        ),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Password
                        ),
                        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            Text(
                                modifier = Modifier
                                    .clickable {
                                        passwordVisibility = !passwordVisibility
                                    },
                                text = stringResource(id = R.string.view)
                            )
                        },
                        shape = RoundedCornerShape(8.dp),
                        placeholder = {
                            Text(text = stringResource(id = R.string.password))
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    CustomButton(
                        text = stringResource(id = R.string.next),
                        onClick = {
                            state.loginFunctions.loginUser?.invoke()
                        }
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = stringResource(id = R.string.forgot_your_password),
                        style = textInfoGreen
                    )
                }
            }
        }
    }
}