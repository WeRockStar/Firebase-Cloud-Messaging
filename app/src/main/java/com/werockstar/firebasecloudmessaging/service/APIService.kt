package com.werockstar.firebasecloudmessaging.service

import com.google.gson.Gson
import com.werockstar.firebasecloudmessaging.model.FirebaseDAO
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody


class APIService {


    val okHttpClient = OkHttpClient.Builder()
            .build()

    fun createRequest(firebaseDAO: FirebaseDAO): RequestBody {
        val json = Gson().toJson(firebaseDAO)
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json.toString())
    }

    fun request(firebaseDAO: FirebaseDAO) = Request.Builder()
            .url("https://fcm.googleapis.com/fcm/send")
            .addHeader("Authorization", FirebaseServerKey.SERVER_KEY)
            .addHeader("Content-Type", "application/json")
            .post(createRequest(firebaseDAO))
            .build()
}