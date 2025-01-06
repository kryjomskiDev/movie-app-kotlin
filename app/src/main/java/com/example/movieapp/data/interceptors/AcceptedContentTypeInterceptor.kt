package com.example.movieapp.data.interceptors


import okhttp3.Interceptor
import okhttp3.Response

object AcceptedContentTypeInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val updatedRequest = request.newBuilder().addHeader("Accept", "application/json").build()
        return chain.proceed(updatedRequest)
    }
}
