package com.khun.chemicalguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khun.chemicalguessinggame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val chemicals = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAddChemical.setOnClickListener {
            val chemicalName = binding.edtChemicalName.text.toString()
            if (chemicalName.isNotBlank()){
                if (chemicals.contains(chemicalName)){
                    binding.tvResult.text = "Chemical '$chemicalName' is already available"
                }else{
                    chemicals.add(chemicalName)
                }
            }
        }

        binding.btnGuess.setOnClickListener {
            val guessName = binding.edtGuess.text.toString()
            if (guessName.isNotBlank() && chemicals.isNotEmpty()){
                val randomChemical = chemicals.random()
                if (randomChemical == guessName)
                    binding.tvResult.text = "Congratulations! You guessed it right. It was $guessName."
                else
                    binding.tvResult.text = "Sorry, wrong guess. The correct answer was $randomChemical."
            }
        }
    }
}