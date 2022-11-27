package com.example.lol_gg.api

sealed class NetworkResult<out T> {
    data class Success<out R>(val value: R) : NetworkResult<R>()
    data class Failure(val message: String?, val throwable: Throwable?, val toastID: Int?) :
        NetworkResult<Nothing>()
}