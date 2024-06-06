package com.example.kotlin_su24_group5.Dish

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.room.Room
import com.example.kotlin_su24_group5.ManagerAdmin
import com.example.kotlin_su24_group5.R

class ListDish : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            getListDish()
        }
    }

}
@Composable
fun getListDish(){
    val context = LocalContext.current
    val  db= Room.databaseBuilder(
        context,
        DishDB::class.java,"DishDb-1"
    ).allowMainThreadQueries().build()

    var listDish by remember {
        mutableStateOf(db.DishDao().getAll())
    }

    var deleteDish by remember { mutableStateOf<DishModel?>(null) }

    var editDish by remember { mutableStateOf<DishModel?>(null) }

    var dialogMessage by remember {
        mutableStateOf("")
    }

    LazyColumn(
        modifier = Modifier.background(color = Color.Black)
    ) {

        item { getback() }
            items(listDish)
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            dialogMessage = it.getShowDish()

                        }
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF2F2D2D))
                    ) {

                        Row(modifier = Modifier.padding(8.dp)) {

//                      Text(modifier = Modifier.weight(1f), text = it.idDish.toString())
////                    Text(modifier = Modifier.weight(1f), text = it.TenMon.toString())
////                    Text(modifier = Modifier.weight(1f), text = it.HinhAnh.toString())
////                    Text(modifier = Modifier.weight(1f), text = it.GiaBan.toString())
                            Text(
                                text = it.idDish.toString(),
                                fontSize = 18.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.comtam),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .size(64.dp)
                                    .clip(RoundedCornerShape(8.dp)),
                                contentScale = ContentScale.Crop

                            )
                            Spacer(modifier = Modifier.width(8.dp))


                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .align(Alignment.CenterVertically)
                            ) {
                                Text(text = it.TenMon.toString(), fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                Text(text = it.GiaBan.toString(), fontSize = 16.sp, color = Color(0xFFFE724C))
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_create_24),
                                contentDescription = "Update",
                                tint = Color.White,
                                modifier = Modifier
                                    .size(30.dp)
                                    .align(Alignment.CenterVertically)
                                    .clickable {
                                        editDish = it
                                    }
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_delete_24),
                                contentDescription = "Delete",
                                tint = Color.White,
                                modifier = Modifier
                                    .size(30.dp)
                                    .align(Alignment.CenterVertically)
                                    .clickable {
                                        deleteDish = it
                                    }
                            )
                        }
                    }


                }
                Divider()
            }

    }
    if (deleteDish !=null){
        ShowDialogDelete(
            it =deleteDish!! ,
            onConfirmation ={deletedDish ->
                db.DishDao().delete(deletedDish)
                listDish=db.DishDao().getAll()
                deleteDish=null
                Toast.makeText(context,"Xóa Thành Công Món Ăn ",Toast.LENGTH_SHORT).show()
            },
            onDismiss = {
                deleteDish=null

            }
        )
    }

    if (editDish !=null){
        ShowDialogEdit(
            it =editDish!! ,
            onConfirmation ={editdDish ->
                db.DishDao().update(editdDish)
                listDish=db.DishDao().getAll()
                editDish=null
                Toast.makeText(context,"Update Thành Cong",Toast.LENGTH_SHORT).show()
            },
            onDismiss = {
                editDish=null

            }
        )
    }


    Add()
}

@Composable
fun Add(){
    val context = LocalContext.current
    Image(
        painter = painterResource(id = R.drawable.baseline_add_24),
        contentDescription = null,
        modifier = Modifier
            .padding(top = 780.dp)
            .padding(start = 340.dp)
            .size(50.dp)
            .background(Color(0xFFBDF1E9), shape = RoundedCornerShape(14.dp))
            .clickable { Next(context) }
    )

}
fun Next (context: Context) {
    val intent = Intent(context, AddDish::class.java)
    context.startActivity(intent)
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    getback()
}

@Composable
fun getback(){
    val context = LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color("#252121".toColorInt()))
            .height(100.dp)


    ) {
        Icon(
            Icons.Default.ArrowBack, contentDescription ="" ,
            Modifier
                .size(40.dp)
                .clickable { BackList(context) },
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

fun BackList (context: Context) {
    val intent = Intent(context, ManagerAdmin::class.java)
    context.startActivity(intent)
}