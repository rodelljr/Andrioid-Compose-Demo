package com.roger.composedemo.helper

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

data class Dessert(val icon: ImageVector ,val name: String, val desertType: String)

val deserts = listOf(
    Dessert(Icons.Default.Face, "Chocolate Chip", "Cookie"),
    Dessert(Icons.Default.Check, "Oatmeal Raisin", "Cookie"),
    Dessert(Icons.Default.ArrowBack, "Rocky Road", "Ice Cream"),
    Dessert(Icons.Default.Favorite, "Bunny Tracks", "Ice Cream"),
    Dessert(Icons.Default.Email, "Apple Crisp", "Pie"),
    Dessert(Icons.Default.Home, "Banana Cream", "Pie"),
    Dessert(Icons.Default.Create, "Snicker Doodle", "Cookie"),
    Dessert(Icons.Default.Info, "German Chocolate", "Cake"),
    Dessert(Icons.Default.LocationOn, "Red Velvet", "Cake"),
    Dessert(Icons.Default.Done, "Vanilla", "Ice Cream"),
)
