package com.jersson.loginapp.presentation.ui.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.SnackbarDefaults
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
import com.jersson.loginapp.presentation.ui.model.LoginState
import com.jersson.loginapp.presentation.ui.theme.colorGreen
import com.jersson.loginapp.presentation.ui.theme.textInfo
import com.jersson.loginapp.presentation.ui.theme.textInfoGreen
import com.jersson.loginapp.presentation.ui.theme.tittle
import com.jersson.loginapp.R

@Composable
fun SignUpScreen(
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
                text = stringResource(id = R.string.sign_up),
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
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = stringResource(id = R.string.looks_like_you_dont_have_an_account),
                        style = textInfo
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = stringResource(id = R.string.Lets_create_a_new_account_for),
                        style = textInfo
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = state.loginData.email,
                        style = textInfo
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = state.loginData.name,
                        onValueChange = {
                            state.loginFunctions.updateData?.invoke(
                                state.loginData.copy(
                                    name = it
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
                            Text(text = stringResource(id = R.string.name))
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = state.loginData.password,
                        onValueChange = {
                            state.loginFunctions.updateData?.invoke(
                                state.loginData.copy(
                                    password = it
                                )
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = colorGreen,
                            unfocusedBorderColor = Color.White,
                            backgroundColor = Color.White
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Next
                        ),
                        shape = RoundedCornerShape(8.dp),
                        placeholder = {
                            Text(text = stringResource(id = R.string.password))
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = stringResource(id = R.string.by_selecting_agree_and_continue_below),
                        style = textInfo
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(id = R.string.i_agree_to),
                            style = textInfo
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            modifier = Modifier
                                .clickable {
                                    state.loginNavigation.signUp?.invoke()
                                },
                            text = stringResource(id = R.string.term_of_service_and_privacy_policy),
                            style = textInfoGreen
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    CustomButton(
                        text = stringResource(id = R.string.agree_and_continue),
                        onClick = {

                        }
                    )
                }
            }
        }
    }
}