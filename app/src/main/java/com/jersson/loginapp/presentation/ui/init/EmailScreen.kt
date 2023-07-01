package com.jersson.loginapp.presentation.ui.init

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jersson.loginapp.R
import com.jersson.loginapp.presentation.ui.components.CustomButton
import com.jersson.loginapp.presentation.ui.model.LoginState
import com.jersson.loginapp.presentation.ui.theme.colorGreen
import com.jersson.loginapp.presentation.ui.theme.typeErrorTitle

@Composable
fun EmailScreen(
    state: LoginState = LoginState()
){
    AnimatedVisibility(visible = state.validateEmail) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = typeErrorTitle,
            text = stringResource(id = R.string.enter_a_email)
        )
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = state.data.email,
        onValueChange = {
            state.loginFunctions.updateData?.invoke(
                state.data.copy(
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
            state.loginFunctions.findUser?.invoke()
        }
    )
}