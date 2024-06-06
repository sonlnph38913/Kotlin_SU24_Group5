package com.example.kotlin_su24_group5

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class ManHinhChao : ComponentActivity(), CoroutineScope {

    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
        setContent {
            Man1()
        }
        launch {
            delay(3000) // Wait for 3 seconds
            startActivity(Intent(this@ManHinhChao, Login::class.java))
            finish()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}

@Composable
fun Man1() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.logospl),
            contentDescription = null
        )
    }
}