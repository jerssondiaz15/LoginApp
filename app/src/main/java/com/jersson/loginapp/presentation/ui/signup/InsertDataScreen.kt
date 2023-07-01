package com.jersson.loginapp.presentation.ui.signup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jersson.loginapp.R
import com.jersson.loginapp.presentation.ui.model.LoginState
import com.jersson.loginapp.presentation.ui.theme.colorGreen
import com.jersson.loginapp.presentation.ui.theme.typeErrorTitle

@Composable
fun InsertDataScreen(
    state: LoginState = LoginState()
){
    var passwordVisibility: Boolean by rememberSaveable { mutableStateOf(false) }

    Spacer(modifier = Modifier.height(16.dp))
    AnimatedVisibility(visible = state.validateName) {
        Text(
            textAlign = TextAlign.Center,
            style = typeErrorTitle,
            text = stringResource(id = R.string.enter_a_name)
        )
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = state.data.name,
        onValueChange = {
            state.loginFunctions.updateData?.invoke(
                state.data.copy(
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
    AnimatedVisibility(visible = state.validatePasswordSignup) {
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
}