package com.example.vinhexample.vo

sealed class ReliaResource<out T> {
    class Success<T>(val data: T? = null) : ReliaResource<T>()
    class Error(val code: Int, val message: String) : ReliaResource<Nothing>()

}