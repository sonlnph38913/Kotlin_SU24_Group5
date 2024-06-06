package com.example.kotlin_su24_group5.Dish

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

import com.example.kotlin_su24_group5.R
import com.example.kotlin_su24_group5.ui.theme.Kotlin_SU24_Group5Theme

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Kotlin_SU24_Group5Theme {
//        ShowDialogEdit {
//
//        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowDialogEdit(
    it: DishModel,
    onConfirmation: (DishModel) -> Unit,
    onDismiss: () -> Unit
) {

    var editedTenMon by remember { mutableStateOf(it.TenMon ?: "") }
    var editeGia by remember { mutableStateOf(it.GiaBan.toString()) }
    Dialog(onDismissRequest = onDismiss) {
        Card {
            Column(
                modifier = Modifier.fillMaxSize()
                    .background(Color(0xFF242020))
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.comtam),
                    contentDescription = "Sample Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(150.dp)
                )

                Spacer(modifier = Modifier.height(60.dp))

                TextField(
                    value = editedTenMon,
                    onValueChange = { editedTenMon=it },
                    label = { Text("Ten Mon") },
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                    ,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = editeGia,
                    onValueChange = { editeGia=it },
                    label = { Text("Ten Mon") },
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                    ,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White
                    )
                )

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = {
                              val editdDish=it.copy(
                                  TenMon = editedTenMon,
                                  GiaBan = editeGia.toFloat()
                              )
                        onConfirmation(editdDish)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp), // Add padding to the Button
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA000))
                ) {
                    Text("Sửa", color = Color.White, fontSize = 18.sp)
                }

                Button(
                    onClick =onDismiss,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp), // Add padding to the Button
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA000))
                ) {
                    Text("Hủy", color = Color.White, fontSize = 18.sp)
                }



            }
        }
    }

    }
