package com.khun.sportnewsandinformation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.khun.sportnewsandinformation.data.atheletes
import com.khun.sportnewsandinformation.databinding.FragmentAthletesBinding
import com.khun.sportnewsandinformation.ui.adapter.AtheleteAdapter

class AthletesFragment : Fragment() {
    private var _binding: FragmentAthletesBinding? = null
    private val binding get() = _binding!!

    private val atheleteAdapter = AtheleteAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAthletesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvAthelete.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAthelete.adapter = atheleteAdapter

        atheleteAdapter.atheletes = atheletes
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}