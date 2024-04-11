package com.khun.sportnewsandinformation.ui.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.textfield.TextInputEditText
import com.khun.sportnewsandinformation.R
import com.khun.sportnewsandinformation.data.atheletes
import com.khun.sportnewsandinformation.data.models.Athelete
import com.khun.sportnewsandinformation.data.models.News
import com.khun.sportnewsandinformation.data.newsList
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

        binding.fab.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Add new Athlete")

            val view = layoutInflater.inflate(R.layout.dialog_item_layout_add_athlete, null)
            builder.setView(view)
            val edtName = view.findViewById<TextInputEditText>(R.id.edtName)
            val edtMainCompeting = view.findViewById<TextInputEditText>(R.id.edtMainCompeting)
            val edtCountry = view.findViewById<TextInputEditText>(R.id.edtCountry)
            val edtPersonalBest = view.findViewById<TextInputEditText>(R.id.edtPersonalBest)
            val edtAward = view.findViewById<TextInputEditText>(R.id.edtAward)
            val edtFact = view.findViewById<TextInputEditText>(R.id.edtFact)


            builder.setPositiveButton("Add"){ dialog, which ->
                val name = edtName.text.toString()
                val mainCompeting = edtMainCompeting.text.toString()
                val country = edtCountry.text.toString()
                val personalBest = edtPersonalBest.text.toString()
                val award = edtAward.text.toString()
                val fact = edtFact.text.toString()

                if (name.isBlank() || mainCompeting.isBlank() || country.isBlank() || personalBest.isBlank() || award.isBlank() || fact.isBlank()){
                    Toast.makeText(requireContext(), "Please complete all field", Toast.LENGTH_LONG).show()
                }else{
                    atheletes.add(Athelete(name, mainCompeting, country, personalBest, award, fact))
                    atheleteAdapter.atheletes = atheletes
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