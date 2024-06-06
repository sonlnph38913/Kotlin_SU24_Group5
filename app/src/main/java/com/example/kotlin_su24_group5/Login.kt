package com.example.kotlin_su24_group5

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin_su24_group5.ui.theme.Kotlin_SU24_Group5Theme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login1()

        }
    }


    @Composable
    fun Login1(){
        val context = LocalContext.current
        Column (
            modifier = Modifier.fillMaxSize()
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .background(Color.Black)
                    .padding(top = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ){
                Text(
                    text ="Đăng Nhập",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
                Image(modifier = Modifier.fillMaxSize(),  painter = painterResource(id = R.drawable.logospl),
                    contentDescription = null)
            }

            Column(

                modifier = Modifier
                    .background(Color.DarkGray)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = null,
                        modifier = Modifier.size(200.dp)
                            .clickable { Next(context)}
                    )
            }

        }



    }




    fun Next (context: Context) {
        val intent = Intent(context, SignIn::class.java)
        context.startActivity(intent)
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Login1()
    }


}