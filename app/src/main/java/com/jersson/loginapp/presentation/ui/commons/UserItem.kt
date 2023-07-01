package com.jersson.loginapp.presentation.ui.commons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.jersson.loginapp.domain.model.User
import com.jersson.loginapp.presentation.ui.theme.textInfo
import com.jersson.loginapp.presentation.ui.theme.textInfoTittle

@Composable
fun UserItem(
    user: User
){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(72.dp)
                .clip(CircleShape),
            painter = rememberAsyncImagePainter(model = user.avatar),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column{
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "${user.firstName!!} ${user.lastName!!}",
                style = textInfoTittle
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = user.email ?: "",
                style = textInfo
            )
        }
    }
}