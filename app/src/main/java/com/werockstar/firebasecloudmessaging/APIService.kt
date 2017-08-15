package com.werockstar.firebasecloudmessaging

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request


object APIService {
    val okHttp = OkHttpClient.Builder()
            .addNetworkInterceptor({ it.proceed(FirebaseHeader.request) })
            .build()
}