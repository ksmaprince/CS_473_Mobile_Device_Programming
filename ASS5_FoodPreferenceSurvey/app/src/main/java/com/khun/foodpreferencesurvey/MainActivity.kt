package com.khun.foodpreferencesurvey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khun.foodpreferencesurvey.databinding.ActivityMainBinding

const val FOOD_SURVEY = "food survey"
const val DIET_HABIT = "diet survey"
const val SURVEY_TYPE = "survey"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartSurvey.setOnClickListener {
            val intent = Intent(this, SurveyActivity::class.java)
            if(binding.rgSurvey.checkedRadioButtonId == R.id.rbFoodPreference){
                intent.putExtra(SURVEY_TYPE, FOOD_SURVEY)
            }else{
                intent.putExtra(SURVEY_TYPE, DIET_HABIT)
            }
            startActivity(intent)
        }
    }
}