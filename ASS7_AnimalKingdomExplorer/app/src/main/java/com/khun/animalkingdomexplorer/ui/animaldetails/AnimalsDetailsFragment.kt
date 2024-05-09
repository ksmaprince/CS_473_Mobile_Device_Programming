package com.khun.animalkingdomexplorer.ui.animaldetails

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.textfield.TextInputEditText
import com.khun.animalkingdomexplorer.R
import com.khun.animalkingdomexplorer.data.model.Animal
import com.khun.animalkingdomexplorer.databinding.FragmentAnimalsDetailsBinding


class AnimalsDetailsFragment : Fragment() {
    private var _binding: FragmentAnimalsDetailsBinding? = null
    private val binding get() = _binding!!
    private val animalAdapter = AnimalAdapter()
    private lateinit var animalViewModel: AnimalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimalsDetailsBinding.inflate(inflater, container, false)
        animalViewModel = AnimalViewModel(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvAnimals.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAnimals.adapter = animalAdapter

        animalViewModel.allAnimals.observe(viewLifecycleOwner) {
            animalAdapter.animals = it
        }

        binding.fabAdd.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Add Animal")

            val inputDialog = layoutInflater.inflate(R.layout.dialog_item_layout_add_animal, null)
            builder.setView(inputDialog)
            val edtName = inputDialog.findViewById<TextInputEditText>(R.id.edtName)
            val edtHabitat = inputDialog.findViewById<TextInputEditText>(R.id.edtHabitat)
            val edtDiet = inputDialog.findViewById<TextInputEditText>(R.id.edtDiet)

            builder.setPositiveButton("Save") { dialog, which ->
                val name = edtName.text.toString()
                val habitat = edtHabitat.text.toString()
                val diet = edtDiet.text.toString()

                if (name.isBlank() || habitat.isBlank() || diet.isBlank()) {
                    Toast.makeText(requireContext(), "Please complete all fields", Toast.LENGTH_LONG)
                        .show()
                } else {
                    animalViewModel.saveAnimal(Animal(name = name, habitat = habitat, diet = diet))
                }
            }

            builder.setNegativeButton("Cancel") { dialog, which ->
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