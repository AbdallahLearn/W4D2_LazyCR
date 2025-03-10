package com.example.w4d2_lazycr

import android.os.Bundle
import android.util.Log

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material3.Card
import androidx.compose.ui.unit.dp


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.ui.unit.dp
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.sp
import androidx.core.view.WindowInsetsControllerCompat
import com.example.w4d2_lazycr.ui.theme.W4D2_LazyCRTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.statusBarColor = android.graphics.Color.BLACK

        // Ensure the icons are white for contrast
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false

        setContent {
            W4D2_LazyCRTheme {
                val categories = listOf(
                    FoodCategory(1, "Fast Food", "Burgers & Fries", "burger.png"),
                    FoodCategory(2, "Desserts", "Cakes & Ice Cream", "desserts.png"),
                    FoodCategory(3, "Beverages", "Juices & Coffee", "beverages.png")
                )

                val menuItems = listOf(
                    MenuItem(1, "Cheeseburger", 5.99, "A delicious cheeseburger", "Fast Food", "burger.png", true),
                    MenuItem(2, "Chocolate Cake", 3.50, "Rich and creamy chocolate cake", "Desserts", "desserts.png", false),
                    MenuItem(3, "Iced Coffee", 2.99, "Cold brewed iced coffee", "Beverages", "beverages.png", true),
                    MenuItem(1, "Cheeseburger", 5.99, "A delicious cheeseburger", "Fast Food", "burger.png", true),
                    MenuItem(2, "Chocolate Cake", 3.50, "Rich and creamy chocolate cake", "Desserts", "desserts.png", false),
                    MenuItem(3, "Iced Coffee", 2.99, "Cold brewed iced coffee", "Beverages", "beverages.png", true),
                    MenuItem(1, "Cheeseburger", 5.99, "A delicious cheeseburger", "Fast Food", "burger.png", true),
                    MenuItem(2, "Chocolate Cake", 3.50, "Rich and creamy chocolate cake", "Desserts", "desserts.png", false),
                    MenuItem(3, "Iced Coffee", 2.99, "Cold brewed iced coffee", "Beverages", "beverages.png", true)
                    )

                Scaffold {
                    Column(
                        modifier = Modifier.fillMaxSize() // Ensure the Column takes full screen
                    ) {
                        CategoryRow(categories, it)
                        MenuItemList(menuItems)
                    }
                }
            }
        }
    }
}

@Composable
fun MenuItemList(menuItems: List<MenuItem>) {
    Log.d("MenuItemList", "Items count: ${menuItems.size}") // Log the number of items

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White) // Just for debugging
    ) {
        items(menuItems) { menuItem ->
            MenuItemRow(menuItem)
        }
    }
}

@Composable
fun MenuItemRow(menuItem: MenuItem) {
    Log.d("MenuItemRow", "Rendering: ${menuItem.name}") // Log for debugging

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Ensure the image is loading correctly.
            Image(
                painter = painterResource(id = getDrawableResourceId(menuItem.imageUrl)),
                contentDescription = menuItem.name,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = menuItem.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$${menuItem.price}",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = menuItem.description,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }

            // Popular badge
            if (menuItem.isPopular) {
                Box(
                    modifier = Modifier
                        .background(Color.Red, shape = CircleShape)
                        .padding(8.dp)
                ) {
                    Text(
                        text = "Popular",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryRow(categories: List<FoodCategory>, innerPadding: PaddingValues) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth() // Ensure the LazyRow fills the width
            .padding(innerPadding) // Ensure padding is applied
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(categories) { category ->
            CategoryItem(category)
        }
    }
}

@Composable
fun CategoryItem(category: FoodCategory) {
    Box(
        modifier = Modifier
            .background(Color.Yellow)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable {},
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = getDrawableResourceId(category.imageUrl)),
                contentDescription = category.description,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = category.name,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun getDrawableResourceId(imageName: String): Int {
    return LocalContext.current.resources.getIdentifier(
        imageName.substringBefore("."),
        "drawable",
        LocalContext.current.packageName
    )
}

