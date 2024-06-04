package com.example.kotlin_su24_group5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ManagerAdmin : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        getLayoutManagerAD()
        }
    }
}
@Preview
@Composable
fun getLayoutManagerAD(){
    Box (modifier = Modifier
        .background(color = Color("#252121".toColorInt()))
        .fillMaxHeight()){
        LazyColumn (
        ){
            item { getHeaderDetail() }
            item { getContentMnAdmin() }

        }
    }

}
@Composable
fun getContentMnAdmin(){
    Column (
        modifier = Modifier
            .background(color = Color("#252121".toColorInt()))

    ) {
        getKC()
        getLoaiAdmin()
        getMonAnAdmin()

    }
    }
@Composable
fun getLoaiAdmin(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color("#252121".toColorInt()))
            .height(100.dp)


    ) {
        Image(painter = painterResource(id = R.drawable.logospl),
            contentDescription = "logo",
            modifier = Modifier
                .size(60.dp)
                .padding(start = 10.dp)
        )
        Text(text = "Quản Lý Loại Món Ăn",
            style = TextStyle(
                color = Color("#FFFFFF".toColorInt()),
                fontSize = 18.sp,
                lineHeight = 22.sp,

                ),
            modifier = Modifier.padding(start = 15.dp)
        )
    }
}
@Composable
fun getMonAnAdmin(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color("#252121".toColorInt()))
            .height(100.dp)


    ) {
        Image(painter = painterResource(id = R.drawable.logospl),
            contentDescription = "logo",
            modifier = Modifier
                .size(60.dp)
                .padding(start = 10.dp)
        )
        Text(text = "Quản Lý Món Ăn",
            style = TextStyle(
                color = Color("#FFFFFF".toColorInt()),
                fontSize = 18.sp,
                lineHeight = 22.sp,

                ),
            modifier = Modifier.padding(start = 15.dp)
        )
    }
}