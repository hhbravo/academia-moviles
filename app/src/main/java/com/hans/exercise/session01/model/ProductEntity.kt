package com.hans.exercise.session01.model

import java.io.Serializable

data class ProductEntity(
    val id: Int, val name: String,
    val price: Double, val photo: Int, val description: String,
    val stock: Boolean
) : Serializable