package com.jersson.loginapp.presentation.ui.utils

fun String.isValidEmail(): Boolean {
    val emailRegex = Regex("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
    return emailRegex.matches(this)
}