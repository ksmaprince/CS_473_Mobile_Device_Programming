package com.khun.electronicgadgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.khun.electronicgadgets.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var gagetAdapter: GagetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val products = ArrayList<Product>()
        products.add(Product("iPad", "iPad Pro 11-inch", 400.0))
        products.add(Product("MacBook M3 Pro", "12-core CPU\n18-core GPU", 2500.00))
        products.add(Product("Dell Inspiron", "13th Gen Intel® CoreTM i7", 1499.00))
        products.add(Product("Logitech Keyboard", "Logitech - PRO X\nTKL LIGHTSPEED Wireless", 199.00))
        products.add(Product("MacBook M3 Max", "14-core CPU\n30-core GPU", 3499.00))

        gagetAdapter = GagetAdapter()
        binding.rvProduct.layoutManager = LinearLayoutManager(this)
        binding.rvProduct.adapter = gagetAdapter
        gagetAdapter.products = products

    }
}