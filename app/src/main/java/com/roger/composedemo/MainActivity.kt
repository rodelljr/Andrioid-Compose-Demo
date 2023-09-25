package com.roger.composedemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.roger.composedemo.helper.BottomNavItem
import com.roger.composedemo.ui.app.BottomNavBar
import com.roger.composedemo.ui.app.Convert
import com.roger.composedemo.ui.app.MyList
import com.roger.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                Bars()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeDemoTheme {
        Bars()
    }
}

@Composable
fun BottomNav(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Convert", Modifier.padding(bottom = 60.dp)) {
        composable("Convert") {
            Convert()
        }

        composable("MyList") {
            MyList()
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Bars() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Compose Demo",
                        color = Color.White
                    )
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.secondaryVariant,
                elevation = 0.dp
            )
        },
        content = {

            BottomNav(navController = navController)
        },

        bottomBar = {
            BottomNavBar(
                items = listOf(
                    BottomNavItem(
                        name = "Convert",
                        route = "Convert",
                        icon = Icons.Default.Home
                    ),
                    BottomNavItem(
                        name = "My List",
                        route = "MyList",
                        icon = Icons.Default.List
                    )
                ),
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                })
        }
    )
}

