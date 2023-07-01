package com.jersson.loginapp.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200
)

val tittle = TextStyle(
    color = Color.White,
    fontSize = 32.sp,
    fontWeight = FontWeight.Bold
)

val textButton = TextStyle(
    color = Color.White,
    fontSize = 16.sp,
    fontWeight = FontWeight.Normal
)

val textInfo = TextStyle(
    color = Color.White,
    fontSize = 16.sp,
    fontWeight = FontWeight.Normal
)

val textInfoTittle = TextStyle(
    color = Color.White,
    fontSize = 18.sp,
    fontWeight = FontWeight.Bold
)

val textInfoGreen = TextStyle(
    color = colorGreen,
    fontSize = 16.sp,
    fontWeight = FontWeight.Normal
)

val textButtonLogin = TextStyle(
    color = Color.Black,
    fontSize = 16.sp,
    fontWeight = FontWeight.Bold
)

val typeErrorTitle = TextStyle(
    color = borderInputError,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
)