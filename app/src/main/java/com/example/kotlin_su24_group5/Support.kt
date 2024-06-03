package com.example.kotlin_su24_group5

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt

class Support : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
//            Scaffold (
//
//                topBar ={
//                    TopAppBar(
//                        title = {
//                            GetTextTitle("Cưm tưứm ")
//                        },
//                        image ={
//                               GetImage(idRes : Int= R.drawable.zalo)
//                        },
//                        colors = TopAppBarDefaults.topAppBarColors(
//                            containerColor = Color("#252121".toColorInt()),
//                            titleContentColor = MaterialTheme.colorScheme.onPrimary,
//                            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
//                            actionIconContentColor = MaterialTheme.colorScheme.onSecondary
//
//
//
//                        ))
//
//                }, content = {
            getLayoutSupport()

        }


    }
}


@Preview(showBackground = true)

@Composable
fun getLayoutSupport(){
    Column {
        getHeaderSupport()
        GetLayout1()


    }
}
@Composable
fun GetLayout1( title: String = "Cưm tứm đim", innerPadding: PaddingValues = PaddingValues(0.dp)) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.Black)
            .padding(
                top = innerPadding.calculateTopPadding() + 150.dp,
                start = 50.dp,
                end = 10.dp,
                bottom = 10.dp,
            )
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){

//        Greeting1(name = "Địa chỉ nhận hàng ")
//        Greeting2(name = "Nguễn Đình Tuấn Phong \n" +
//                " Hoàn Kiếm - Hà Nội \n" +
//                " 0975123114")
//        Greeting3(name = "Vui lòng chọn các phương thức sau!")
        GetRowItem1(color = Color.Black, R.drawable.zalo, "0987654321")
        GetRowItem1(color = Color.Black, R.drawable.gmail,"cumtumdim@gmail.com")
        GetRowItem1(color = Color.Black, R.drawable.phone, "0987654321")


//        SimpleButton()
    }



}

@Composable
fun GetRowItem1(color: Color , idRes : Int= R.drawable.zalo, title: String ="Paypal"){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = color, shape = RoundedCornerShape((12.dp)))
            .height(70.dp)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,

        ){
        Image(painter = painterResource(id = idRes), contentDescription ="" , modifier = Modifier.width(60.dp))
        Text(
            text = title,
            modifier = Modifier
                .weight(1f)
                .padding(50.dp, 0.dp, 0.dp, 0.dp),
            color = Color.White,

            )

    }
}

@Composable
fun GetTextTitle1(msg: String , innerPadding: PaddingValues = PaddingValues(0.dp)) {
    Text(
        text = msg,
        modifier = Modifier
            .padding(0.dp, 20.dp)
            .fillMaxWidth(),
        color = Color.White,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,

        )
}

@Composable
fun GetImage1(idRes: Int= R.drawable.zalo, innerPadding: PaddingValues = PaddingValues(0.dp)) {
    Image(painter = painterResource(id = idRes), contentDescription ="" , modifier = Modifier.width(60.dp))
}
@Composable
fun getHeaderSupport() {
    Box(
        modifier = Modifier.fillMaxWidth()
            .background(color = Color.DarkGray)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,  // Align items vertically centered in the Row
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 15.dp, end = 30.dp, bottom = 10.dp) // Added end padding
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "logo",
                modifier = Modifier
                    .width(44.dp)
                    .height(44.dp)
            )
            Spacer(modifier = Modifier.width(8.dp)) // Space between Image and Column
            Column(
                modifier = Modifier.weight(1f) // Column takes up the remaining space
            ) {
                Text(
                    text = "Cưm tứm đim",
                    style = TextStyle(
//                        fontFamily = customFontFamily,
                        fontSize = 28.sp,
                        color = Color.White,
                        lineHeight = 45.sp,

                        ),
                    modifier = Modifier.padding() // Center horizontally within Column
                )
//                Text(
//                    text = "BEAUTIFUL",
//                    style = TextStyle(
////                        fontFamily = customFontFamily,
//                        fontSize = 18.sp,
//                        color = Color("#303030".toColorInt()),
//                        lineHeight = 45.sp
//                    ),
//                    modifier = Modifier.align(Alignment.CenterHorizontally) // Center horizontally within Column
//                )
            }
            Spacer(modifier = Modifier.width(8.dp)) // Space between Column and new Image
//            Image(
//                painter = painterResource(id = R.drawable.zalo), // Replace with your image resource
//                contentDescription = "New Image",
//                modifier = Modifier
//                    .width(24.dp)
//                    .height(24.dp)
//            )
        }
    }

}

//@Composable
//fun Greeting1(name: String) {
//    Text(
//        text = " $name",
//        modifier = Modifier
//            .padding(
//                top = 50.dp,
//                start = 10.dp,
//                end = 10.dp,
//                bottom = 0.dp
//            )
//            .fillMaxWidth(),
//
//        color = Color.LightGray,
//        fontSize = 20.sp,
//        fontWeight = FontWeight.Bold,
//        textAlign = TextAlign.Start,
//
//
//        )
//}
//@Composable
//fun Greeting2(name: String) {
//    Text(
//        text = " $name",
//        modifier = Modifier
//            .padding(20.dp, 0.dp)
//            .fillMaxWidth(),
//
//        color = Color.LightGray,
//        fontSize = 15.sp,
//        fontWeight = FontWeight.Bold,
//        textAlign = TextAlign.Start,
//
//        )
//}
//
//@Composable
//fun Greeting3(name: String) {
//    Text(
//        text = " $name",
//        modifier = Modifier
//            .padding(10.dp, 0.dp)
//            .fillMaxWidth(),
//
//        color = Color.LightGray,
//        fontSize = 15.sp,
//        fontWeight = FontWeight.Bold,
//        textAlign = TextAlign.Start,
//
//        )
//}
//@Composable
//fun SimpleButton() {
//    Button(onClick = {
////your onclick code here
//    },colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray))
//
//
//    {
//
//        Text(text = "Tiếp theo")
//    }
//}
