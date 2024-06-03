package com.example.kotlin_su24_group5

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController


class SignIn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()

        }
    }

    @Composable
    fun LoginScreen() {
        val context = LocalContext.current
        Box(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxSize()

        ) {
            Top()
            Login(context = context)
            SignUp()

        }

    }

    @Composable
    fun Top(){
        Row(
            modifier = Modifier
                .height(350.dp)
                .padding(top = 30.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo1),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()

            )


        }
    }



    @Composable
    fun Login(context: Context) {
        val defaulUser = "kotlin"
        val defaultPassword = "123"
        var user by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var isLoggedIn by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 150.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = user,
                    onValueChange = { user = it },
                    label = { Text("User") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(

                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 10.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                Box (
                    modifier = Modifier
                        .padding(top = 60.dp),


                ){

                    Button(
                        onClick = {
                            if (password == defaultPassword &&  user==defaulUser) {
                                val intent = Intent(context, Menu::class.java)
                                context.startActivity(intent)
                                Toast.makeText(context, "Welcome To Group5", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(context, "Tên người dùng hoặc mật khẩu không hợp lệ", Toast.LENGTH_SHORT).show()
                            }
                        },
                        enabled = !isLoggedIn,
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        modifier = Modifier.size(width = 280.dp, height = 50.dp)

                        ) {
                        Text(
                            text = "Login",
                            color = Color.White,
                            fontSize = 25.sp
                        )
                    }


                }


            }
        }
    }

    @Composable
    fun SignUp(){
        val context = LocalContext.current
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 500.dp),
            contentAlignment = Alignment.Center
        ){
            Button(
                onClick = {val intent = Intent(context, SignUp::class.java)
                    context.startActivity(intent)},
                colors = ButtonDefaults.buttonColors(Color.White),

                ) {
                Text(
                    text = "Sign Up",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

            }
        }

    }





    @Preview(showBackground = true)
    @Composable
    fun PreviewLogin(){
        LoginScreen()
    }
}