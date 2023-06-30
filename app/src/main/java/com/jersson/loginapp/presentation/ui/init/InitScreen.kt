package com.jersson.loginapp.presentation.ui.init

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.jersson.loginapp.presentation.ui.components.CustomButton
import com.jersson.loginapp.presentation.ui.components.LoginButton
import com.jersson.loginapp.presentation.ui.model.LoginState
import com.jersson.loginapp.presentation.ui.theme.colorGreen
import com.jersson.loginapp.presentation.ui.theme.textInfo
import com.jersson.loginapp.presentation.ui.theme.textInfoGreen
import com.jersson.loginapp.presentation.ui.theme.tittle
import com.jersson.loginapp.R

@Composable
fun InitScreen(
    state: LoginState = LoginState()
) {
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
                text = stringResource(id = R.string.hi),
                style = tittle
            )
            Box(
                modifier = Modifier
                    .padding(
                        vertical = 16.dp,
                        horizontal = 4.dp
                    )
                    .background(
                        color = backgroundColor.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .padding(26.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = state.loginData.email,
                        onValueChange = {
                            state.loginFunctions.updateData?.invoke(
                                state.loginData.copy(
                                    email = it
                                )
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = colorGreen,
                            unfocusedBorderColor = Color.White,
                            backgroundColor = Color.White
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        ),
                        shape = RoundedCornerShape(8.dp),
                        placeholder = {
                            Text(text = stringResource(id = R.string.email))
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    CustomButton(
                        text = stringResource(id = R.string.next),
                        onClick = {
                            state.loginNavigation.logIn?.invoke()
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(id = R.string.or),
                        style = textInfo
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    LoginButton(
                        text = stringResource(id = R.string.continue_with_facebook),
                        onClick = {

                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    LoginButton(
                        text = stringResource(id = R.string.continue_with_google),
                        onClick = {

                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    LoginButton(
                        text = stringResource(id = R.string.continue_with_apple),
                        onClick = {

                        }
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(id = R.string.dont_have_an_account),
                            style = textInfo
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            modifier = Modifier
                                .clickable {
                                    state.loginNavigation.signUp?.invoke()
                                },
                            text = stringResource(id = R.string.sign_up),
                            style = textInfoGreen
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {

                            },
                        text = stringResource(id = R.string.forgot_your_password),
                        style = textInfoGreen
                    )
                }
            }
        }
    }
}