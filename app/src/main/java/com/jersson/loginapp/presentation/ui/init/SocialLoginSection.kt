package com.jersson.loginapp.presentation.ui.init

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jersson.loginapp.R
import com.jersson.loginapp.presentation.ui.components.LoginButton

@Composable
fun SocialLoginSection(){
    Spacer(modifier = Modifier.height(16.dp))
    LoginButton(
        image = painterResource(id = R.drawable.ic_facebook),
        text = stringResource(id = R.string.continue_with_facebook),
        onClick = {

        }
    )
    Spacer(modifier = Modifier.height(16.dp))
    LoginButton(
        image = painterResource(id = R.drawable.ic_google),
        text = stringResource(id = R.string.continue_with_google),
        onClick = {

        }
    )
    Spacer(modifier = Modifier.height(16.dp))
    LoginButton(
        image = painterResource(id = R.drawable.ic_apple),
        text = stringResource(id = R.string.continue_with_apple),
        onClick = {

        }
    )
}