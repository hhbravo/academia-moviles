package com.hans.exercise.session01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.hans.exercise.session01.model.ProductEntity

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

//class MainActivity : AppCompatActivity(), OnProductListener {
class MainActivity : AppCompatActivity() {

    //private lateinit var productsFragment: ProductsFragment

    //private lateinit var detailProductFragment: DetailProductFragment
    //private lateinit var fragmentManager: FragmentManager

    private lateinit var viewModel: ProductViewModel


//    override fun selectedItemProduct(productEntity: ProductEntity) {
//        detailProductFragment.renderProduct(productEntity)
//    }


//    override fun renderFirst(productEntity: ProductEntity?) {
//        productEntity?.let {
//            selectedItemProduct(it)
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ProductViewModel::class.java)

        //observers

        viewModel.productSelected.observe(this, Observer<ProductEntity> {
            Log.v("CONSOLE", "activity $it")
        })

    }
}
