package com.werockstar.firebasecloudmessaging

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.TextView
import butterknife.OnClick

class MainActivity : AppCompatActivity() {

    private lateinit var tvMessage: TextView
    private lateinit var btnSubscribe: Button
    private lateinit var btnUnsubscribe: Button
    private lateinit var tvToken: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        tvMessage = findViewById(R.id.tvMessage) as TextView
        btnSubscribe = findViewById(R.id.btnSubscribe) as Button
        btnUnsubscribe = findViewById(R.id.btnUnsubscribe) as Button
        tvToken = findViewById(R.id.tvToken) as TextView

        tvMessage.text = intent.getStringExtra("MESSAGE") ?: ""
    }

    @OnClick(R.id.btnUnsubscribe) fun onUnsubscribe() {

    }

    @OnClick(R.id.btnSubscribe) fun onSubscribe() {

    }

}
