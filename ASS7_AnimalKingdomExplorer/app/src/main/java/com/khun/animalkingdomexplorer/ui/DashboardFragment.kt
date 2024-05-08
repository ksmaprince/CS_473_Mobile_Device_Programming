package com.khun.animalkingdomexplorer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.khun.animalkingdomexplorer.R
import com.khun.animalkingdomexplorer.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAnimalsDetails.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_animalsDetailsFragment)
        }

        binding.btnSpeciesDetails.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_speciesFragment)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}