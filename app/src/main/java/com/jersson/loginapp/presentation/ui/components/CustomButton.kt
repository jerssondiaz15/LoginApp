package com.jersson.loginapp.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jersson.loginapp.presentation.ui.theme.colorGreen
import com.jersson.loginapp.presentation.ui.theme.textButton
import com.jersson.loginapp.presentation.ui.theme.textButtonLogin

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorGreen
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = text,
            style = textButton
        )
    }
}

@Composable
fun LoginButton(
    image: Painter,
    text: String,
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Image(
            modifier = Modifier
                .size(24.dp),
            painter = image,
            contentDescription = ""
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = text,
            style = textButtonLogin,
            textAlign = TextAlign.Center
        )
    }
}