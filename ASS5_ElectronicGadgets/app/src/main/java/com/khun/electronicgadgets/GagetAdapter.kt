package com.khun.electronicgadgets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.khun.electronicgadgets.databinding.ItemLayoutBinding

class GagetAdapter: Adapter<GagetAdapter.GagetViewHolder>(){
    var products: List<Product> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    inner class GagetViewHolder(val binding: ItemLayoutBinding): ViewHolder(binding.root){
        fun bind(product: Product){
            binding.tvProductName.text = product.productName
            binding.tvCost.text = product.cost.toString()
            binding.tvProductDescription.text = product.productDescription
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GagetViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GagetViewHolder(binding)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: GagetViewHolder, position: Int) {
        holder.bind(products[position])
    }
}