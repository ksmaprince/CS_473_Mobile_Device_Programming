package com.khun.animalkingdomexplorer.ui.speciesdetails

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.khun.animalkingdomexplorer.data.model.Species
import com.khun.animalkingdomexplorer.databinding.ListItemSpeciesBinding

class SpeciesAdapter : Adapter<SpeciesAdapter.SpeciesViewHolder>() {

    var species = listOf<Species>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class SpeciesViewHolder(private val binding: ListItemSpeciesBinding) :
        ViewHolder(binding.root) {
        fun bind(species: Species) {
            binding.tvName.text = species.name
            binding.tvDescription.text = species.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeciesViewHolder {
        val binding =
            ListItemSpeciesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpeciesViewHolder(binding)
    }

    override fun getItemCount(): Int = species.size

    override fun onBindViewHolder(holder: SpeciesViewHolder, position: Int) {
        holder.bind(species[position])
    }
}