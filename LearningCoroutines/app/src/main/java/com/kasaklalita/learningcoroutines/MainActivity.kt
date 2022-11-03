package com.kasaklalita.learningcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val networkCallAnswer = doNetworkCall()
            val networkCallAnswer2 = doNetworkCall2()
            Log.d("MainActivity", networkCallAnswer)
            Log.d("MainActivity", networkCallAnswer2)
        }
        Log.d("MainActivity", "hello from thread ${Thread.currentThread().name}")
    }

    suspend fun doNetworkCall(): String {
        delay(3000L)
        return "This is the answer"
    }
    suspend fun doNetworkCall2(): String {
        delay(3000L)
        return "This is the answer"
    }
}