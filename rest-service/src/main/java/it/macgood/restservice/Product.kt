package it.macgood.restservice

data class Product(
    val id: Int,
    val name: String,
    val price: String,
    val salePrice: String = "0",
    val extraPrice: String = "0"
)
