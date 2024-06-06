package com.example.kotlin_su24_group5

import android.content.ClipData.Item
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailProduct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GetDetailProduct()
        }
    }


}
@Preview
@Composable
 fun GetDetailProduct(){
    Box (modifier = Modifier
        .background(color = Color("#252121".toColorInt()))
        .fillMaxHeight()){
        LazyColumn (
        ){
           item { getHeaderDetail() }
            item { getKC() }
            item { getContentDetail() }


        }
    }

}

@Composable
fun getHeaderDetail(){
    val context = LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color("#252121".toColorInt()))
            .height(100.dp)


    ) {
        Icon(Icons.Default.ArrowBack, contentDescription ="" ,
            Modifier
                .size(40.dp)
                .clickable { BackMain(context) },
            tint = Color.White
        )

        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .size(60.dp)
                .padding(start = 10.dp)
            )
        Text(text = "Cum tứm đim",
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
fun getContentDetail(){
    Column (
        modifier = Modifier
            .background(color = Color("#252121".toColorInt()))

    ){
        getButtonDetail()
        getListMonChinh()
        getListMonThem()
        getListTopping()
        getListSPKhac()
        getThongTinKH()
    }
}
@Composable
fun getButtonDetail(){
    Row (
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .background(color = Color("#252121".toColorInt()))
    ){
        getButtonXN()
        getButtonCancel()

    }
}
@Composable
fun getButtonXN(){
    Surface(
        modifier = Modifier
            .width(160.dp)
            .height(40.dp)
            .padding(top = 10.dp, end = 10.dp)
        ,
        color = Color("#2f2d2d".toColorInt()),
        contentColor = Color.White,
        shape = MaterialTheme.shapes.small
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Xác Nhận",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 22.85.sp,
                    color = Color.White
                )

            )

        }
    }
}
@Composable
fun getButtonCancel(){
    Surface(
        modifier = Modifier
            .width(160.dp)
            .height(40.dp)
            .padding(start = 10.dp, top = 10.dp)
        ,
        color = Color("#2f2d2d".toColorInt()),
        contentColor = Color.White,
        shape = MaterialTheme.shapes.small
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Hủy",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 22.85.sp,
                    color = Color.White
                )

            )

        }
    }
}
@Composable
fun getListMonChinh(){
    Column (
    modifier = Modifier.background(color = Color("#252121".toColorInt()))
    ){
        Text(text = "Món Chính",
            style = TextStyle(
                color = Color("#FFFFFF".toColorInt())
            ),
            modifier = Modifier.padding(top = 10.dp, start = 15.dp)
        )
        Divider(
            color = Color("#BDBDBD".toColorInt()), // Màu của đường kẻ
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 15.dp, end = 15.dp)
        )
    }
}
@Composable
fun getListMonThem(){
    Column (
        modifier = Modifier.background(color = Color("#252121".toColorInt()))
    ){
        Text(text = "Món Thêm",
            style = TextStyle(
                color = Color("#FFFFFF".toColorInt())
            ),
            modifier = Modifier.padding(top = 10.dp, start = 15.dp)
        )
        Divider(
            color = Color("#BDBDBD".toColorInt()), // Màu của đường kẻ
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 15.dp, end = 15.dp)
        )
    }
}
@Composable
fun getListTopping(){
    Column (
        modifier = Modifier.background(color = Color("#252121".toColorInt()))
    ){
        Text(text = "Topping",
            style = TextStyle(
                color = Color("#FFFFFF".toColorInt())
            ),
            modifier = Modifier.padding(top = 10.dp, start = 15.dp)
        )
        Divider(
            color = Color("#BDBDBD".toColorInt()), // Màu của đường kẻ
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 15.dp, end = 15.dp)
        )
    }
}
@Composable
fun getListSPKhac(){
    Column (
        modifier = Modifier.background(color = Color("#252121".toColorInt()))
    ){
        Text(text = "Khác",
            style = TextStyle(
                color = Color("#FFFFFF".toColorInt())
            ),
            modifier = Modifier.padding(top = 10.dp, start = 15.dp)
        )
        Divider(
            color = Color("#BDBDBD".toColorInt()), // Màu của đường kẻ
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 15.dp, end = 15.dp)
        )
    }
}
@Composable
fun getThongTinKH(){
    Column (
        modifier = Modifier
            .background(color = Color("#252121".toColorInt()))
            .padding(top = 15.dp, bottom = 30.dp)
    ){
        getTextTT(text = "Số Nhà : 54")
        getTextTT(text = "Đường : 14")
        getTextTT(text = "Phường : Đông Hưng Thuận")
        getTextTT(text = "Quận 12")
        getTextTT(text = "Thành Phố : Hồ Chí Minh")
        Divider(
            color = Color("#BDBDBD".toColorInt()), // Màu của đường kẻ
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 15.dp, end = 15.dp)
        )
        getTextTT(text = "Giờ : 13h45p")
        getTextTT(text = "SĐT : 0866704364")
        getTextTT(text = "Tổng Số Lượng Món Ăn : 4")
        getTextTT(text = "Tổng Số Lượng Món Ăn Thêm : 3")
        getTextTT(text = "Tổng Số Lượng Topping : 2")
        getTextTT(text = "Tổng Số Lượng Khác : 2")
        getTextTT(text = "Tổng Tiền : 133k")
    }
}
@Composable
fun getTextTT(text : String){
    Column (
        modifier = Modifier.padding(top = 10.dp,start = 15.dp)
    ) {
        Text(
            text = text,
            color = Color.White
        )
    }

}

@Composable
fun getKC(){
    Column (
        modifier = Modifier
            .background(color = Color("#000000".toColorInt()))
            .height(20.dp)
            .fillMaxWidth()
    ){

    }
}

fun BackMain (context: Context) {
    val intent = Intent(context, Menu::class.java)
    context.startActivity(intent)
}

