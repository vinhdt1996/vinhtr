package com.example.vinhexample.ext

import android.content.Context
import com.example.vinhexample.R

fun Context.handleErrorAuth(email: String, password: String): String? {
    return when {
        email.isEmpty() -> getString(R.string.err_email_empty)
        !email.isValidEmail() -> getString(R.string.err_email_invalid)
        password.isEmpty() -> getString(R.string.err_password_empty)
        !password.isValidPassword() -> getString(R.string.err_password_invalid)
        else -> null
    }
}