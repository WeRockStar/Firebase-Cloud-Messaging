package com.werockstar.firebasecloudmessaging

import okhttp3.Headers
import okhttp3.Request
import okhttp3.internal.http2.Header

object FirebaseHeader {
    val request = Request.Builder()
            .addHeader("Authorization", "KEY_SERVER")
            .addHeader("Content-Type", "application/json")
            .build()
}