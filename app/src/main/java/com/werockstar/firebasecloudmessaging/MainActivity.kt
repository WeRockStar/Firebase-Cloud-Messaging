package com.werockstar.firebasecloudmessaging

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tvMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        tvMessage = findViewById(R.id.tvMessage) as TextView
        tvMessage.text = intent.getStringExtra("MESSAGE") ?: ""

    }

}
