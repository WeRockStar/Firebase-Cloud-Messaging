package com.werockstar.firebasecloudmessaging.model

import com.google.gson.annotations.SerializedName

class FirebaseDAO(@SerializedName("to") val toUser: String, @SerializedName("priority") val priority: String,
                  @SerializedName("data") val data: DataDAO,
                  @SerializedName("notification") val notificationDAO: NotificationDAO)