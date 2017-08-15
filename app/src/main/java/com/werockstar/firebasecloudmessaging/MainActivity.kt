package com.werockstar.firebasecloudmessaging

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvMessage: TextView
    private lateinit var btnSubscribe: Button
    private lateinit var btnUnsubscribe: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        tvMessage = findViewById(R.id.tvMessage) as TextView
        btnSubscribe = findViewById(R.id.btnSubscribe) as Button
        btnUnsubscribe = findViewById(R.id.btnUnsubscribe) as Button

        tvMessage.text = intent.getStringExtra("MESSAGE") ?: ""

    }

    fun onUnsubscribe() {

    }

    fun onSubscribe() {

    }

}
