package com.hans.exercise.session01

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hans.exercise.session01.model.ProductEntity


class ProductViewModel:ViewModel() {
    val productSelected = MutableLiveData<ProductEntity>()

    fun selecteItemProduct(item: ProductEntity) {
        productSelected.value = item
    }
}