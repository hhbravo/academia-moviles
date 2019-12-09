package com.hans.exercise.session01

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hans.exercise.session01.model.ProductEntity

import androidx.lifecycle.ViewModelProviders
import com.hans.exercise.session01.adapter.ProductAdapter
import kotlinx.android.synthetic.main.fragment_products.*

/**
 * A simple [Fragment] subclass.
 * Use the [ProductsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductsFragment : Fragment() {
    private var products = mutableListOf<ProductEntity>()

    private lateinit var viewModel: ProductViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = activity?.run {
            ViewModelProviders.of(this).get(ProductViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setData()

        context?.let {
            lvProducts.adapter = ProductAdapter(it, products)
        }


        viewModel = activity?.run {
            ViewModelProviders.of(this).get(ProductViewModel::class.java)
        } ?: throw Exception("Invalid Activity")


        lvProducts.setOnItemClickListener { _, _, i, _ ->
            selectedProduct(products[i])
        }

        if (viewModel.productSelected != null) {
            selectedProduct(products[0])
        }
    }


    private fun selectedProduct(productEntity: ProductEntity){
        Log.v("CONSOLE", "ProductsFragment $productEntity")
        viewModel.selecteItemProduct(productEntity)
    }




    private fun setData() {
        products.add(ProductEntity(1, "Monitor", 124.90, R.mipmap.img001, "Monitor", true))
        products.add(ProductEntity(2, "Mp3", 40.10, R.mipmap.img002, "Reproductor Mp3", true))
        products.add(ProductEntity(3, "Iphone 4", 500.40, R.mipmap.img003, "Iphone 4 16Gb", false))
        products.add(ProductEntity(4, "Placa", 124.90, R.mipmap.img004, "Placa madre", true))
    }

}
