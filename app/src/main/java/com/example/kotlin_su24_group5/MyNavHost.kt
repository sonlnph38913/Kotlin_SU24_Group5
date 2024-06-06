package com.example.kotlin_su24_group5

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun MyNavHost(
    navHostController: NavHostController,
    startDestination: String,
) {


//    val user=User()
    val login=Login()


    NavHost(navController = navHostController,
        startDestination = startDestination,
        modifier = Modifier.background(Color.Black),
        builder = {

            composable(NavCons.home) {
                login.Login1()

            }
            composable(NavCons.favorite) {
               getLayoutManagerAD()

            }
            composable(NavCons.thongbao) {
                GetDetailProduct()

            }
            composable(NavCons.user) {
                login.Login1()

            }


        })

}



sealed class Screens(val route: String, val imageVector: ImageVector, val label: String) {
    object Home : Screens(
        route = NavCons.home,
        label = "Home",
        imageVector = Icons.Rounded.Home
    )

    object Favorite : Screens(
        route = NavCons.favorite,
        label = "Favorite",
        imageVector = Icons.Rounded.ShoppingCart
    )
    object Thongbao : Screens(
        route = NavCons.thongbao,
        label = "Thông Báo",
        imageVector = Icons.Rounded.DateRange
    )
    object User : Screens(
        route = NavCons.user,
        label = "User",
        imageVector = Icons.Rounded.AccountCircle
    )


}

object NavCons {
    const val home = "Home"
    const val favorite = "Favorite"
    const val thongbao = "Thongbao"
    const val user = "User"

}
