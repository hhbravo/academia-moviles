package com.hans.exercise.session01


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hans.exercise.session01.adapter.ProductAdapter
import com.hans.exercise.session01.model.ProductEntity
import kotlinx.android.synthetic.main.fragment_products.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProductsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductsFragment : Fragment() {
    private var listener: OnProductListener? = null

    private var products = mutableListOf<ProductEntity>()


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
        lvProducts.setOnItemClickListener { _, _, i, _ ->
            listener?.let {
                it.selectedItemProduct(products[i])
            }
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnProductListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnContactListener")
        }
    }


    private fun setData() {
        products.add(ProductEntity(1, "Monitor", 124.90, R.mipmap.img001, "Monitor", true))
        products.add(ProductEntity(2, "Mp3", 40.10, R.mipmap.img002, "Reproductor Mp3", true))
        products.add(ProductEntity(3, "Iphone 4", 500.40, R.mipmap.img003, "Iphone 4 16Gb", false))
        products.add(ProductEntity(4, "Placa", 124.90, R.mipmap.img004, "Placa madre", true))
    }


    override fun onDetach() {
        super.onDetach()
        listener = null
    }

}
