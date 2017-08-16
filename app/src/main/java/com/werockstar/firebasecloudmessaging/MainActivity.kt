package com.werockstar.firebasecloudmessaging

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.TextView
import butterknife.ButterKnife
import butterknife.OnClick
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import com.werockstar.firebasecloudmessaging.model.DataDAO
import com.werockstar.firebasecloudmessaging.model.FirebaseDAO
import com.werockstar.firebasecloudmessaging.model.NotificationDAO
import com.werockstar.firebasecloudmessaging.service.APIService
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    private lateinit var tvMessage: TextView
    private lateinit var btnSubscribe: Button
    private lateinit var btnUnsubscribe: Button
    private lateinit var tvToken: TextView
    private lateinit var btnToken: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        tvMessage = findViewById(R.id.tvMessage) as TextView
        btnSubscribe = findViewById(R.id.btnSubscribe) as Button
        btnUnsubscribe = findViewById(R.id.btnUnsubscribe) as Button
        tvToken = findViewById(R.id.tvToken) as TextView
        btnToken = findViewById(R.id.btnToken) as Button

        tvMessage.text = intent.getStringExtra("MESSAGE") ?: ""
    }

    @OnClick(R.id.btnToken)
    fun showToken() {
        val token = FirebaseInstanceId.getInstance().token
        tvToken.text = token
    }

    @OnClick(R.id.btnSendTopic)
    fun onClickSendTopic() {
        val firebaseDAO = FirebaseDAO("/topics/sport", "high", DataDAO("https://firebase.google.com/_static/images/firebase/touchicon-180.png"), NotificationDAO("Sport title", "Sport body"))
        val api = APIService()

        Observable.fromCallable({
            api.okHttpClient.newCall(api.request(firebaseDAO)).execute().body()?.string()
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("Response", it)
                }, {
                    Log.d("Error", it.message)
                })


    }

    @OnClick(R.id.btnUnsubscribe)
    fun onUnsubscribe() {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("sport")
    }

    @OnClick(R.id.btnSubscribe)
    fun onSubscribe() {
        FirebaseMessaging.getInstance().subscribeToTopic("sport")
    }

}
