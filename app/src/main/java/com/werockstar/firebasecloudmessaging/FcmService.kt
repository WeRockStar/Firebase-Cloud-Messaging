package com.werockstar.firebasecloudmessaging


import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.net.URL

class FcmService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        showNotification(remoteMessage)
    }

    private fun showNotification(remoteMessage: RemoteMessage) {
        val notificationData = remoteMessage.data
        val imageUrl = notificationData["image"]
        val notification = remoteMessage.notification

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(MESSAGE, notification.body)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent, PendingIntent.FLAG_ONE_SHOT)

        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle(notification.title)
                .setContentText(notification.body)
                .setAutoCancel(true)
                .setColor(Color.parseColor("#4B8A08"))
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)

        val url = URL(imageUrl)
        val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
        /*
            Support library v4 provide BigPictureStyle class
         */
        notificationBuilder.setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap).setSummaryText(notification.body))

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build())
    }

    companion object {
        private val TAG = FcmService::class.java.simpleName
        private val MESSAGE = "MESSAGE"
    }
}
