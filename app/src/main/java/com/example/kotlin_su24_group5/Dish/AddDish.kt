package com.example.kotlin_su24_group5.Dish

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

import androidx.room.Room
import com.example.kotlin_su24_group5.ui.theme.Kotlin_SU24_Group5Theme

class AddDish : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_SU24_Group5Theme {
                    getAddDish(
                        name = "Them Mon an ",

                    )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun getAddDish(name: String, modifier: Modifier = Modifier){

    var Mon by remember { mutableStateOf("Món chính") }
    val LuaChon = listOf("Món chính", "Món phụ")

    var LoaiMon by remember { mutableStateOf("Sườn") }
    val LuaChonLoaiMon = listOf("Sườn nướng", "Sườn Xào", "Cơm" ,"Phở" )

    val context = LocalContext.current
    val  db=Room.databaseBuilder(
        context,
        DishDB::class.java,"DishDb-1"
    ).allowMainThreadQueries().build()
    var listDish by remember {
        mutableStateOf(db.DishDao().getAll())
    }
    var TenMon by remember {
        mutableStateOf("")
    }
    var HinhAnh:String by remember {
        mutableStateOf("")
    }
    var GiaBan:Float by remember {
        mutableFloatStateOf(0f)
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF242020))
            .padding(16.dp),  // Added padding to the column
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Gray, shape = RoundedCornerShape(8.dp))
                .clickable { /* Add image upload functionality */ },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Thêm hình ảnh", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        DropdownMenuBox(Mon, LuaChon) { Mon = it }
        DropdownMenuBox(LoaiMon, LuaChonLoaiMon) { LoaiMon= it }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = TenMon.toString(),
            onValueChange = { TenMon = it},
            label = { Text("Tên Món") },
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = GiaBan.toString(),
            onValueChange = { GiaBan = it.toFloat() },
            label = { Text("Giá") },
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White
            )
        )

            Button(onClick = {
                if (TenMon.trim().equals("")  || GiaBan == null) {
                    Toast.makeText(context, "Chua dien du thong tin!", Toast.LENGTH_SHORT).show()
                } else {
                    db.DishDao().insert(
                        DishModel(
                            TenMon = TenMon,
                            HinhAnh = HinhAnh,
                            GiaBan = GiaBan,

                            )
                    )
                    listDish = db.DishDao().getAll()

                    val intent = Intent(context, ListDish::class.java)
                    context.startActivity(intent)
                }
            },modifier = Modifier
                .width(170.dp)
                .padding(horizontal = 16.dp), // Added padding to the Button
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA000))
            ) {
                Text(text = "Thêm")
            }


    }


}




@Composable
fun DropdownMenuBox(
    selectedOption: String,
    options: List<String>,
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.Gray, shape = RoundedCornerShape(4.dp))
            .clickable { expanded = true }
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = selectedOption, color = Color.White)
            IconButton(
                onClick = { expanded = true },
                modifier = Modifier.size(24.dp)
            ) {
                Icon(Icons.Filled.ArrowDropDown, contentDescription = null)
            }
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    },
                    text = { Text(text = option) } // Added the text modifier
                )
            }
        }
    }
}






