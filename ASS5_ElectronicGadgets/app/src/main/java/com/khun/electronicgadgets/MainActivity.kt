package com.khun.electronicgadgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.khun.electronicgadgets.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var gagetAdapter: GagetAdapter
    val carts = arrayListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val products = ArrayList<Product>()
        products.add(Product("iPad", "iPad Pro 11-inch", 400.0, R.drawable.mac, R.drawable.apple_icon))
        products.add(Product("MacBook M3 Pro", "12-core CPU\n18-core GPU", 2500.00, R.drawable.mac_1, R.drawable.apple_icon))
        products.add(Product("Dell Inspiron", "13th Gen Intel® CoreTM i7", 1499.00, R.drawable.dell, R.drawable.dell_ico))
        products.add(Product("Logitech Keyboard", "Logitech - PRO X\nTKL LIGHTSPEED Wireless", 199.00, R.drawable.logitech, R.drawable.logitech_ico))
        products.add(Product("MacBook M3 Max", "14-core CPU\n30-core GPU", 3499.00, R.drawable.mac_2, R.drawable.apple_icon))

        gagetAdapter = GagetAdapter()
        binding.rvProduct.layoutManager = LinearLayoutManager(this)
        binding.rvProduct.adapter = gagetAdapter
        gagetAdapter.products = products

        gagetAdapter.setOnItemAddListener(object: GagetAdapter.OnAddListener{
            override fun onItemAdd(product: Product) {
                if (!carts.contains(product)){
                    carts.add(product)
                    Toast.makeText(this@MainActivity, "${product.productName} added to cart", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this@MainActivity, "Already added to cart", Toast.LENGTH_SHORT).show()
                }
            }
        })

        gagetAdapter.setOnItemClickListener(object : GagetAdapter.OnItemClickListener{
            override fun onItemClick(product: Product) {
                val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                intent.putExtra("product", product)
                startActivity(intent)
            }
        })

        binding.btnViewCart.setOnClickListener {
            if (carts.isNotEmpty()){
                Toast.makeText(this, carts.toString(), Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "No data added", Toast.LENGTH_LONG).show()
            }
        }

    }
}