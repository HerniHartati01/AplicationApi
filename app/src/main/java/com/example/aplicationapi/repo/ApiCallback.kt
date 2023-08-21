package com.example.aplicationapi.repo

interface ApiCallback<T> {
    fun onResponse(response: T)
    fun onFailure(error: Throwable)
}