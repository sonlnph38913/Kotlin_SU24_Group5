package com.example.kotlin_su24_group5

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.core.graphics.toColorInt
import androidx.room.Room
import com.example.kotlin_su24_group5.ui.theme.Kotlin_SU24_Group5Theme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QLLoaiMonScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_SU24_Group5Theme {
                Scaffold(
                    modifier = Modifier
                        .safeDrawingPadding()
                        .fillMaxSize()
                ) { innerPadding ->
                    GreetingQLMon(
                        name = "Quản lý Loại Món",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GreetingQLMon(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val db = remember {
        Room.databaseBuilder(
            context,
            LoaiMonDB::class.java, "LoaiMon"
        ).allowMainThreadQueries().build()
    }

    var listLoaiMons by remember { mutableStateOf(listOf<LoaiModel>()) }
    var tenloai by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    var showDialogUpdate by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    var selectedLoaiMon by remember { mutableStateOf<LoaiModel?>(null) }
    var selectedLoaiMonUp by remember { mutableStateOf<LoaiModel?>(null) }

    LaunchedEffect(Unit) {
        scope.launch(Dispatchers.IO) {
            listLoaiMons = db.LoaiMonDao().getAllLoaiMon()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(color = Color("#252121".toColorInt()))
    ) {
        getHeaderDetail()
        getKC()
        OutlinedTextField(
            value = tenloai,
            onValueChange = { tenloai = it },
            label = { Text(text = "Tên Loại Món") },
            textStyle = TextStyle(color = Color.Black), // Set text color to black
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
                cursorColor = Color.Black,
                focusedTextColor = Color.Black,
                containerColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        Button(
            onClick = {
                if (tenloai.trim().isEmpty()) {
                    Toast.makeText(context, "Bạn Chưa Điền Đủ Thông Tin!", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    scope.launch(Dispatchers.IO) {
                        try {
                            db.LoaiMonDao().insert(
                                LoaiModel(
                                    tenLoai = tenloai
                                )
                            )
                            listLoaiMons = db.LoaiMonDao().getAllLoaiMon()
                            tenloai = "" // Clear input field
                        } catch (e: Exception) {
                            e.printStackTrace()
                            scope.launch(Dispatchers.Main) {
                                Toast.makeText(
                                    context,
                                    "Lỗi khi thêm loại món!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        ) {
            Text(text = "Thêm Loại Món")
        }
        LazyColumn {
            items(listLoaiMons) { loaiMon ->
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .background(
                            color = Color("#2f2d2d".toColorInt()),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(8.dp)
                ) {
                    Text(
                        text = loaiMon.idLoai.toString(),
                        style = TextStyle(
                            color = Color("#FFFFFF".toColorInt()),
                            fontSize = 24.sp
                        ),
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = loaiMon.tenLoai ?: "",
                        style = TextStyle(
                            color = Color("#FFFFFF".toColorInt()),
                            fontSize = 24.sp
                        ),
                        modifier = Modifier.weight(2f)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.ic_delete),
                        contentDescription = "delete Mon",
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                            .clickable {
                                db.LoaiMonDao().deleteLoaiMon(loaiMon.idLoai)
                                listLoaiMons = db.LoaiMonDao().getAllLoaiMon()
                            }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_edit),
                        contentDescription = "update Mon",
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .clickable {
                                selectedLoaiMonUp = loaiMon
                            }
                    )
                }
            }
        }


    }
        //dialog update
    if (selectedLoaiMonUp != null) {
        ShowEditLoaiDialog(
            loaimon = selectedLoaiMonUp!!,
            onConfirmation = { editedLoai ->
                db.LoaiMonDao().update(editedLoai)
                listLoaiMons = db.LoaiMonDao().getAllLoaiMon()
                selectedLoaiMonUp = null
            },
            onCancel = {
               selectedLoaiMonUp = null
            }
        )
    }
    //dialog xóa
            if (showDialog && selectedLoaiMon != null) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text(text = "Xác nhận") },
                text = { Text(text = "Bạn có chắc chắn muốn xóa loại món này?") },
                confirmButton = {
                    TextButton(
                        onClick = {
                            scope.launch(Dispatchers.IO) {
                                try {
                                    db.LoaiMonDao().deleteLoaiMon(selectedLoaiMon!!.idLoai)
                                    listLoaiMons = db.LoaiMonDao().getAllLoaiMon()
                                    scope.launch(Dispatchers.Main) {
                                        Toast.makeText(context, "Xóa thành công!", Toast.LENGTH_SHORT).show()
                                    }
                                } catch (e: Exception) {
                                    e.printStackTrace()
                                    scope.launch(Dispatchers.Main) {
                                        Toast.makeText(context, "Lỗi khi xóa loại món!", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }
                            showDialog = false
                            selectedLoaiMon = null
                        }
                    ) {
                        Text("Xóa")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            showDialog = false
                            selectedLoaiMon = null
                        }
                    ) {
                        Text("Hủy")
                    }
                }
            )
        }
}
@Composable
fun ShowEditLoaiDialog(
    loaimon: LoaiModel,
    onConfirmation: (LoaiModel) -> Unit,
    onCancel: () -> Unit
) {
    var editedName by remember { mutableStateOf(loaimon.tenLoai ?: "") }


    Dialog(onDismissRequest = onCancel) {
        Card {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                OutlinedTextField(
                    value = editedName,
                    onValueChange = { editedName = it },
                    label = { Text("Tên Loại Món") },
                    modifier = Modifier.fillMaxWidth()
                )

                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            val editedLoaiMon = loaimon.copy(
                                tenLoai = editedName,
                            )
                            onConfirmation(editedLoaiMon)
                        },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text("Lưu")
                    }
                    Button(
                        onClick = onCancel,
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text("Hủy")
                    }
                }
            }
        }
    }
