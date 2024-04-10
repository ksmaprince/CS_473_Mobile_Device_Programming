package com.khun.sportnewsandinformation.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.khun.sportnewsandinformation.ui.fragment.AboutMeFragment
import com.khun.sportnewsandinformation.ui.fragment.AthletesFragment
import com.khun.sportnewsandinformation.ui.fragment.EventsFragment
import com.khun.sportnewsandinformation.ui.fragment.AchievementHistoryFragment
import com.khun.sportnewsandinformation.ui.fragment.NewsFragment
import com.khun.sportnewsandinformation.ui.fragment.SportsFragment

class MainViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment {
       return when(position){
            0 -> SportsFragment()
            1 -> NewsFragment()
            2 -> AthletesFragment()
            3 -> EventsFragment()
            4 -> AchievementHistoryFragment()
            5 -> AboutMeFragment()
           else -> Fragment()
        }
    }
}