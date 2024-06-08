package com.example.kotlin_su24_group5

import android.app.Application
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.kotlin_su24_group5.DataUser.UserViewModel
import com.example.kotlin_su24_group5.Dish.ListDish


class SignIn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        setContent {
            Login(userViewModel) {
                startActivity(Intent(this@SignIn, Menu::class.java))
                finish()
            }

        }
    }





    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Login(userViewModel: UserViewModel, onLoginSuccess: () -> Unit) {
        val context = LocalContext.current
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var loginError by remember { mutableStateOf(false) }
        Column (modifier = Modifier
            .background(color = Color.Black)
            .fillMaxSize()){

            Image(
                painter = painterResource(id = R.drawable.logo1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)

            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(

                        value = username,
                        onValueChange = { username = it },
                        label = { Text("User") },

                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White
                        )

                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White
                        )

                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Box(
                        modifier = Modifier
                            .padding(top = 60.dp),


                        ) {

                        Button(
                            onClick = {
                                userViewModel.loginUser(username, password) { user ->
                                    if (user != null) {
                                        onLoginSuccess()
                                        Toast.makeText(context,"Login Succesfully",Toast.LENGTH_SHORT).show()
                                    } else {
                                        loginError = true
                                        Toast.makeText(context, "Invalid username or password", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            },
                            colors = ButtonDefaults.buttonColors(Color.DarkGray),
                            modifier = Modifier.size(width = 280.dp, height = 50.dp)

                        ) {
                            Text(
                                text = "Login",
                                color = Color.White,
                                fontSize = 25.sp
                            )
                        }
                        if (loginError) {
                            Spacer(modifier = Modifier.height(8.dp))

                        }else{

                        }
                    }

                    Box(
                        modifier = Modifier
                            .padding(top = 30.dp),


                        ) {

                        Button(
                            onClick = {
                                navSignUp(context)
                            },
                            colors = ButtonDefaults.buttonColors(Color.DarkGray),
                            modifier = Modifier.size(width = 280.dp, height = 50.dp)

                            ) {
                            Text(
                                text = "SignUp",
                                color = Color.White,
                                fontSize = 25.sp
                            )
                        }
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewLogin(){
        Login()
    }
}
fun navSignUp(context: Context){
    val intent = Intent(context, SignUpScreen::class.java)
    context.startActivity(intent)
}