package com.hans.exercise.session01


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hans.exercise.session01.model.ProductEntity
import kotlinx.android.synthetic.main.fragment_detail_product.*

/**
 * A simple [Fragment] subclass.
 */
class DetailProductFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_detail_product, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //observers
        viewModel.productSelected.observe(this, productSelectedObserver)
    }

    private val productSelectedObserver = Observer<ProductEntity> {
        Log.v("CONSOLE", "DetailProduct colorSelectedObserver $it")
        renderProduct(viewModel.productSelected.value)
    }


    fun renderProduct(productEntity: ProductEntity?) {
        val name = productEntity?.name
        val description = productEntity?.description
        val price = "S/ ".plus(productEntity?.price)
        val photo = productEntity?.photo

        tviName.text = name
        tviDescription.text = description
        tviPrice.text = price
        iviProduct.setImageResource(photo!!)
    }

}
