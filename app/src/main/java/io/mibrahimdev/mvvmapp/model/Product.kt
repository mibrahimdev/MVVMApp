package io.mibrahimdev.mvvmapp.model

data class Product(
    val productId: Int,
    val name: String,
    val price: Double,
    val isFavorite: Boolean = false
)
