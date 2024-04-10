package com.khun.sportnewsandinformation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.khun.sportnewsandinformation.R
import com.khun.sportnewsandinformation.data.profile
import com.khun.sportnewsandinformation.databinding.FragmentAboutMeBinding

class AboutMeFragment : Fragment() {
    private var _binding: FragmentAboutMeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutMeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireContext())
            .load(profile.imageUrl)
            .into(binding.ivProfile)

        binding.tvName.text = profile.name
        binding.tvSportProfile.text = profile.sportProfile
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}