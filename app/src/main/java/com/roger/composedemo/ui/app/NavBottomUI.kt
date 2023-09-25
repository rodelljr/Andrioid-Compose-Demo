package com.roger.composedemo.ui.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.roger.composedemo.helper.BottomNavItem

@Composable
fun BottomNavBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStack = navController.currentBackStackEntryAsState();
    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primaryVariant,
    ) {
        items.forEach { item ->
            val selected = item.route == backStack.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = MaterialTheme.colors.secondaryVariant,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally ) {
                        Icon (
                            imageVector = item.icon,
                            contentDescription = item.name
                        )
                        Text(text = item.name,
                            textAlign = TextAlign.Center,
                            fontSize = 10.sp
                         )
                    }
                }
            )
        }
    }
}