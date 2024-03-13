package com.khun.foodpreferencesurvey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.khun.foodpreferencesurvey.databinding.ActivitySurveyBinding

class SurveyActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySurveyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val survey = intent.getStringExtra(SURVEY_TYPE)

        if (survey == FOOD_SURVEY) {
            binding.llFoodPreference.visibility = View.VISIBLE
            operateFoodPreferenceSurvey()
        } else {
            binding.llDietPreference.visibility = View.VISIBLE
            operateDietSurevey()
        }
    }

    private fun operateFoodPreferenceSurvey() {
        var cuisine = ""
        var oftenEat = ""
        var spicy = ""
        var vegetarian = ""
        var seafood = ""

        binding.btnSubmit.setOnClickListener {
            findViewById<RadioButton>(binding.rgCuisine.checkedRadioButtonId)?.let {
                cuisine = it.text.toString()
            }
            findViewById<RadioButton>(binding.rgOftenEat.checkedRadioButtonId)?.let {
                oftenEat = it.text.toString()
            }
            findViewById<RadioButton>(binding.rgSpicyFood.checkedRadioButtonId)?.let {
                spicy = it.text.toString()
            }
            findViewById<RadioButton>(binding.rgVegetarian.checkedRadioButtonId)?.let {
                vegetarian = it.text.toString()
            }
            findViewById<RadioButton>(binding.rgSeafood.checkedRadioButtonId)?.let {
                seafood = it.text.toString()
            }

            if (cuisine.isEmpty() || oftenEat.isEmpty() || spicy.isEmpty() || vegetarian.isEmpty() || seafood.isEmpty()){
                Toast.makeText(this, "You need to answer all questions", Toast.LENGTH_LONG).show()
            }else{
                val result = "${getString(R.string.what_is_your_favourite_cuisine)} $cuisine \n" +
                        "${getString(R.string.how_often_do_you_eat_out)} $oftenEat \n" +
                        "${getString(R.string.do_you_prefer_spicy_food)} $spicy \n" +
                        "${getString(R.string.do_you_prefer_vegetarian_food)} $vegetarian \n" +
                        "${getString(R.string.do_you_like_seafood)} $seafood \n"
                binding.tvResult.text = result
            }
        }
    }

    private fun operateDietSurevey() {
        var isVegetarian = ""
        var isOrganic = ""
        var isDairy = ""
        var isFastFood = ""
        var isAllergy = ""

        binding.btnSubmit.setOnClickListener {

            findViewById<RadioButton>(binding.rgIsVegetarian.checkedRadioButtonId)?.let {
                isVegetarian = it.text.toString()
            }
            findViewById<RadioButton>(binding.rgIsOrganicFood.checkedRadioButtonId)?.let {
                isOrganic = it.text.toString()
            }
            findViewById<RadioButton>(binding.rgIsDairyProduct.checkedRadioButtonId)?.let {
                isDairy = it.text.toString()
            }
            findViewById<RadioButton>(binding.rgIsFastFood.checkedRadioButtonId)?.let {
                isFastFood = it.text.toString()
            }
            findViewById<RadioButton>(binding.rgIsFoodAllergy.checkedRadioButtonId)?.let {
                isAllergy = it.text.toString()
            }

            if (isVegetarian.isEmpty() || isOrganic.isEmpty() || isDairy.isEmpty() || isFastFood.isEmpty() || isAllergy.isEmpty()){
                Toast.makeText(this, "You need to answer all questions", Toast.LENGTH_LONG).show()
            }else{
                val result = "${getString(R.string.are_you_vetetarian)} $isVegetarian \n" +
                        "${getString(R.string.do_you_prefer_organic_food)} $isOrganic \n" +
                        "${getString(R.string.do_you_consume_dairy_products)} $isDairy \n" +
                        "${getString(R.string.do_you_eat_fast_food)} $isFastFood \n" +
                        "${getString(R.string.do_you_have_any_food_allergies)} $isAllergy \n"
                binding.tvResult.text = result
            }
        }
    }
}