package com.khun.animalkingdomexplorer.ui.speciesdetails

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.khun.animalkingdomexplorer.R
import com.khun.animalkingdomexplorer.databinding.FragmentSpeciesDetailsBinding

class SpeciesDetailsFragment : Fragment() {
    private var _binding: FragmentSpeciesDetailsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpeciesDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabAdd.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Add Species")

            val view = layoutInflater.inflate(R.layout.dialog_item_layout_add_species, null)
            builder.setView(view)
            val edtName = view.findViewById<TextInputEditText>(R.id.edtName)
            val edtDescription = view.findViewById<TextInputEditText>(R.id.edtDescription)

            builder.setPositiveButton("Save") { dialog, which ->
                val name = edtName.text.toString()
                val description = edtDescription.text.toString()

                if (name.isBlank() || description.isBlank()) {
                    Toast.makeText(requireContext(), "Please complete all field", Toast.LENGTH_LONG)
                        .show()
                } else {
                    //Add Logic will be here
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