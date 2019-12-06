package com.hans.exercise.session01.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.hans.exercise.session01.R
import com.hans.exercise.session01.model.ProductEntity

class ProductAdapter(private val context: Context, private val products: List<ProductEntity>) :
    BaseAdapter() {


    override fun getItem(position: Int): Any = products[position]

    override fun getItemId(p0: Int): Long = 0

    override fun getCount(): Int = products.size


    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        val container = inflater.inflate(R.layout.row_product, null)

        val ivProduct = container.findViewById<ImageView>(R.id.ivProduct)
        val tvName = container.findViewById<TextView>(R.id.tvName)
        val tvPrice = container.findViewById<TextView>(R.id.tvPrice)
        val tvStock = container.findViewById<TextView>(R.id.tvStock)

        val entity = products[position]

        tvName.text = entity.name
        tvPrice.text = "S/ ".plus(entity.price.toString())
        tvStock.text = if (entity.stock) "In Stock" else "Not Stock"
        ivProduct.setImageResource(entity.photo)

        return container

    }
}