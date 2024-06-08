package com.example.kotlin_su24_group5


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_su24_group5.ui.theme.Kotlin_SU24_Group5Theme


class Menu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlin_SU24_Group5Theme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                        .background(color = Color.Black),
                    color = MaterialTheme.colorScheme.onBackground
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        modifier = Modifier.background(Color.Black)
                            .fillMaxWidth(),
                        bottomBar = {
                            BottomNav( navController = navController)

                        }
                    ) {
                        it
                        MyNavHost(
                            navHostController = navController,
                            startDestination = Screens.Home.route

                        )
                    }
                }

            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        BottomNav(navController = NavHostController(this))
    }

}
@Composable
fun BottomNav(
    navController: NavHostController,
) {
    var selectedIndex by remember {

        mutableIntStateOf(0)
    }
    val list = listOf(
        Screens.Home,
        Screens.Favorite,
        Screens.Thongbao,
        Screens.User,
        )
    NavigationBar(
        modifier = Modifier.background(Color.Black),
        Color.Transparent

            

    ) {
        list.forEachIndexed { index, screens ->
            NavigationBarItem(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),

                selected = selectedIndex == index,
                onClick = {
                    navController.navigate(screens.route)
                    selectedIndex = index
                },

                icon = {
                    Icon( imageVector = screens.imageVector,
                        contentDescription = "",
                        tint = Color.White)
                },
                label = {
                    Text(text = screens.label, color = Color.White)

                },
                alwaysShowLabel = false

            )
        }
    }


}





