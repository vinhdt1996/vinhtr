package com.example.vinhexample.model

data class ErrorResponse(
    val error: String? = null,
    val email: ArrayList<String>? = null
)