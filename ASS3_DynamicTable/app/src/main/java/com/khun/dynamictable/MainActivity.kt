package com.khun.dynamictable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.setPadding
import com.khun.dynamictable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener {
            addRow()
        }
    }

    private fun addRow(){
        val resourceName = binding.edtWaterResource.text.toString()
        val location = binding.edtLocation.text.toString()
        val type = binding.edtType.text.toString()

        if (resourceName.isEmpty() || location.isEmpty() || type.isEmpty()){
            Toast.makeText(this, "All fields are required", Toast.LENGTH_LONG).show()
            return
        }
        val row = TableRow(this)
        val tvResourceName = TextView(this)
        val tvLocation = TextView(this)
        val tvType = TextView(this)

        tvResourceName.text = resourceName
        tvLocation.text = location
        tvType.text = type

        tvResourceName.setBackgroundResource(R.drawable.border_bg)
        tvLocation.setBackgroundResource(R.drawable.border_bg)
        tvType.setBackgroundResource(R.drawable.border_bg)
        tvResourceName.setPadding(5)
        tvLocation.setPadding(5)
        tvType.setPadding(5)

        row.addView(tvResourceName)
        row.addView(tvLocation)
        row.addView(tvType)

        binding.tableLayout.addView(row)

        binding.edtWaterResource.text.clear()
        binding.edtLocation.text.clear()
        binding.edtType.text.clear()
        Toast.makeText(this, "Row added successfully", Toast.LENGTH_LONG).show()
    }
}