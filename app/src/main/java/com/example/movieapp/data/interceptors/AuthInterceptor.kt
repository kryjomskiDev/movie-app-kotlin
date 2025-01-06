package com.example.movieapp.data.interceptors


import okhttp3.Interceptor
import okhttp3.Response

const val AUTHORIZATION = "Authorization"
const val BEARER = "Bearer"
const val TOKEN =
    "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwMDkxYjA0Y2ZjNWQ3NjViOTlmN2IzODg2YjdlYjM4MSIsIm5iZiI6MTY5NDY4NjUxOS43NDUsInN1YiI6IjY1MDJkZDM3ZmZjOWRlMGVlMTc4MDAyNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.s_nPtWkIPOcNwmm065kog1nsp87MLYk0pzxiqIWAU2k"

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        requestBuilder.addHeader(AUTHORIZATION, "$BEARER $TOKEN")

        return chain.proceed(requestBuilder.build())
    }
}