package io.mibrahimdev.mvvmapp.model

import com.google.gson.GsonBuilder
import java.lang.reflect.Type
/**
 * Mocking some data
 *
 * */
val fakeProducts = listOf(
    Product(
        productId = 903, name = "Sneakers", price = 29.99
    ), Product(
        productId = 904, name = "Wristwatch", price = 49.99
    ), Product(
        productId = 905, name = "Sunglasses", price = 39.99
    ), Product(
        productId = 906, name = "Backpack", price = 70.99
    ), Product(
        productId = 907, name = "Smartphone", price = 320.5
    )
)

inline fun <reified T> String.fromJson(typeToken: Type): T {
    val gson = GsonBuilder().create()
    return gson.fromJson(this, typeToken)
}