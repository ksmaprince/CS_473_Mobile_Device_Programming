package com.khun.sportnewsandinformation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.khun.sportnewsandinformation.data.achievementHistories
import com.khun.sportnewsandinformation.databinding.FragmentAchievementHistoryBinding
import com.khun.sportnewsandinformation.ui.adapter.AchievementHistoryAdapter

class AchievementHistoryFragment : Fragment() {
    private var _binding: FragmentAchievementHistoryBinding? = null
    private val binding get() = _binding!!

    private val achievementHistoryAdapter = AchievementHistoryAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAchievementHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvAchievement.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAchievement.adapter = achievementHistoryAdapter

        achievementHistoryAdapter.achievementHistories = achievementHistories
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}