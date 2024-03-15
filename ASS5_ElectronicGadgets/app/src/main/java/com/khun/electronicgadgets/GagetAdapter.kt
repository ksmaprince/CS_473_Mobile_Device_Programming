package com.khun.electronicgadgets

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.khun.electronicgadgets.databinding.ItemLayoutBinding

class GagetAdapter: Adapter<GagetAdapter.GagetViewHolder>(){
    var products: List<Product> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private lateinit var itemAddListener: OnAddListener

    private lateinit var itemClickListener: OnItemClickListener

    fun setOnItemAddListener(onAddListener: OnAddListener){
        this.itemAddListener = onAddListener
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        this.itemClickListener = onItemClickListener
    }

    interface OnAddListener{
        fun onItemAdd(product: Product)
    }

    interface OnItemClickListener{
        fun onItemClick(product: Product)
    }
    inner class GagetViewHolder(val binding: ItemLayoutBinding): ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(product: Product){
            binding.tvProductName.text = product.productName
            binding.tvCost.text = "$ ${product.cost}"
            binding.tvProductDescription.text = product.productDescription
            Glide.with(binding.root.context).load(product.image).into(binding.ivProduct)
            Glide.with(binding.root.context).load(product.icon).into(binding.ivIcon)
            binding.btnAdd.setOnClickListener {
                if (adapterPosition != NO_POSITION){
                    itemAddListener.onItemAdd(product)
                }
            }

            binding.ctrLayout.setOnClickListener {
                if (adapterPosition != NO_POSITION){
                    itemClickListener.onItemClick(product)
                }
            }
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