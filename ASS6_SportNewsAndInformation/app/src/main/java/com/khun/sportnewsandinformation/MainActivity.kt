package com.khun.sportnewsandinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.khun.sportnewsandinformation.databinding.ActivityMainBinding
import com.khun.sportnewsandinformation.ui.adapter.MainViewPagerAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vpager.adapter = MainViewPagerAdapter(this)
        TabLayoutMediator(binding.tab, binding.vpager) { tab, position ->
            when(position){
                0 -> tab.setText("Sports")
                1 -> tab.setText("News")
                2 -> tab.setText("Athletes")
                3 -> tab.setText("Events")
                4 -> tab.setText("Historical Achieves")
                5 -> tab.setText("About Me")
            }
        }.attach()

        binding.bottomNavView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_news -> binding.vpager.setCurrentItem(1, true)
                R.id.menu_event -> binding.vpager.setCurrentItem(3, true)
                R.id.menu_historical_achieves -> binding.vpager.setCurrentItem(4, true)
            }
            return@setOnItemSelectedListener true
        }
    }
}