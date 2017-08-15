package com.werockstar.firebasecloudmessaging.service

import okhttp3.Request

object FirebaseHeader {
    val request = Request.Builder()
            .addHeader("Authorization", "KEY_SERVER")
            .addHeader("Content-Type", "application/json")
            .build()
}