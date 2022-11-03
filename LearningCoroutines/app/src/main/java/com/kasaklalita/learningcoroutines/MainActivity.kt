package com.kasaklalita.learningcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            Log.d(TAG, "Starting corouting in thread ${Thread.currentThread().name}")
            val answer = doNetworkCall()
            withContext(Dispatchers.Main) {
                Log.d(TAG, "Setting text in thread ${Thread.currentThread().name}")
                tvDummy.text = answer
            }
        }
    }
}

suspend fun doNetworkCall(): String {
    delay(3000L)
    return "This is the answer"
}

suspend fun doNetworkCall2(): String {
    delay(3000L)
    return "This is the answer"
}
