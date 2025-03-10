package com.example.w4d2_lazycr

data class MenuItem(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String,
    val category: String,
    val imageUrl: String,
    val isPopular: Boolean
)

