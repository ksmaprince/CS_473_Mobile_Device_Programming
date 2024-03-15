package com.khun.electronicgadgets

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.khun.electronicgadgets.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val product = intent.getSerializableExtra("product") as Product

        Glide.with(this).load(product.image).into(binding.ivProduct)
        binding.tvProductName.text = product.productName
        binding.tvProductDescription.text = product.productDescription
        binding.tvCost.text = "$ ${product.cost}"


        binding.btnHome.setOnClickListener {
            finish()
        }
    }
}