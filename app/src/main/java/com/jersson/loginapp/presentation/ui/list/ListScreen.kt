package com.jersson.loginapp.presentation.ui.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp
import com.jersson.loginapp.R
import com.jersson.loginapp.presentation.ui.commons.UserItem
import com.jersson.loginapp.presentation.ui.model.LoginState
import com.jersson.loginapp.presentation.ui.theme.tittle

@Composable
fun ListScreen(
    state: LoginState = LoginState()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
    ) {
        AnimatedVisibility(
            visibleState = MutableTransitionState(true),
            enter = expandHorizontally(),
            exit = shrinkHorizontally()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .padding(
                            horizontal = 30.dp,
                            vertical = 16.dp
                        ),
                    text = stringResource(id = R.string.our_users),
                    style = tittle
                )
                LazyColumn {
                    items(items = state.listUsers){ user ->
                        Spacer(modifier = Modifier.height(16.dp))
                        UserItem(
                            user = user
                        )
                    }
                }
            }
        }
    }
}