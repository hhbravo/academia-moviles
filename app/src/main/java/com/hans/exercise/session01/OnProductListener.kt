package com.hans.exercise.session01

import com.hans.exercise.session01.model.ProductEntity

interface OnProductListener {

    fun selectedItemProduct(productEntity: ProductEntity)
}