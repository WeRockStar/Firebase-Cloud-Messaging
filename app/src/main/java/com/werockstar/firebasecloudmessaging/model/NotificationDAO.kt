package com.werockstar.firebasecloudmessaging.model

import com.google.gson.annotations.SerializedName

class NotificationDAO constructor(@SerializedName("title") private val title: String,
                                  @SerializedName("body") private val body: String)