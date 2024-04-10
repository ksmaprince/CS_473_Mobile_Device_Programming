package com.khun.sportnewsandinformation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.khun.sportnewsandinformation.data.sports
import com.khun.sportnewsandinformation.databinding.FragmentSportsBinding
import com.khun.sportnewsandinformation.ui.adapter.SportsAdapter

class SportsFragment : Fragment() {
    private var _binding: FragmentSportsBinding? = null
    private val binding get() = _binding!!

    private val sportsAdapter = SportsAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSportsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvSport.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvSport.adapter = sportsAdapter

        sportsAdapter.sports = sports

        binding.fab.setOnClickListener {
            Toast.makeText(requireContext(), "Add data click", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}