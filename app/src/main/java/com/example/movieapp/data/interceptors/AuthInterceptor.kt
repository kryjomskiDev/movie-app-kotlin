package com.example.movieapp.data.interceptors


import okhttp3.Interceptor
import okhttp3.Response

const val AUTHORIZATION = "Authorization"
const val BEARER = "Bearer"
const val TOKEN = ""

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        requestBuilder.addHeader(AUTHORIZATION, "$BEARER $TOKEN")

        return chain.proceed(requestBuilder.build())
    }
}