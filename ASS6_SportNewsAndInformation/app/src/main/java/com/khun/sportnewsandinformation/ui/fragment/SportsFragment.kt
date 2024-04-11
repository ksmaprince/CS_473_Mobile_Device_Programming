package com.khun.sportnewsandinformation.ui.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.textfield.TextInputEditText
import com.khun.sportnewsandinformation.R
import com.khun.sportnewsandinformation.data.models.Sport
import com.khun.sportnewsandinformation.data.sports
import com.khun.sportnewsandinformation.databinding.DialogItemLayoutAddSportBinding
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
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Add new Sport")

            val view = layoutInflater.inflate(R.layout.dialog_item_layout_add_sport, null)
            builder.setView(view)
            val spnType = view.findViewById<Spinner>(R.id.spnType)
            val edtName = view.findViewById<TextInputEditText>(R.id.edtName)
            val edtInstruction = view.findViewById<TextInputEditText>(R.id.edtInstruction)
            var sportType = ""
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, requireContext().resources.getStringArray(R.array.sport_type))
            spnType.adapter = adapter
            spnType.onItemSelectedListener = object : OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    sportType = parent!!.getItemAtPosition(position).toString()
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }
            builder.setPositiveButton("Add"){ dialog, which ->
                val sportName = edtName.text.toString()
                val instruction = edtInstruction.text.toString()
                if (sportName.isBlank() || instruction.isBlank()){
                    Toast.makeText(requireContext(), "Please complete all field", Toast.LENGTH_LONG).show()
                }else{
                    sports.add(Sport(sportType, edtName.text.toString(), edtInstruction.text.toString()))
                    sportsAdapter.sports = sports
                }
            }

            builder.setNegativeButton("Cancel"){ dialog, which ->
                dialog.cancel()
            }

            builder.create().show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}