package com.khun.electronicgadgets

import java.io.Serializable


data class Product(
    val productName: String,
    val productDescription: String,
    val cost: Double,
    val image: Int,
    val icon: Int
): Serializable{
    override fun toString(): String {
        return productName
    }
}
