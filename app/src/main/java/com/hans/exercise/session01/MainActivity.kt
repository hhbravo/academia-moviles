package com.hans.exercise.session01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.hans.exercise.session01.model.ProductEntity

class MainActivity : AppCompatActivity(), OnProductListener {


    private lateinit var productsFragment: ProductsFragment
    private lateinit var fragmentManager: FragmentManager



    override fun selectedItemProduct(productEntity: ProductEntity) {
        //productDetailFragment.renderContact(contactEntity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager= supportFragmentManager
        productsFragment= fragmentManager.findFragmentById(R.id.fragProducts) as ProductsFragment
    }
}
