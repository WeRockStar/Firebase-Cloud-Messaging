package com.werockstar.firebasecloudmessaging.service

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody


class APIService {

    fun okHttpClient() = OkHttpClient.Builder()
            .addNetworkInterceptor({ it.proceed(FirebaseHeader.request) })
            .build()

    val create = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "")

    fun request() = Request.Builder()
            .url("https://fcm.googleapis.com/fcm/send")
            .post(create)
            .build()

    fun reponse() = okHttpClient().newCall(request()).execute().body()?.string()

}