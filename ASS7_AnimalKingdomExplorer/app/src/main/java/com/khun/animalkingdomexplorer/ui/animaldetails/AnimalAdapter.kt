package com.khun.animalkingdomexplorer.ui.animaldetails

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.khun.animalkingdomexplorer.data.model.Animal
import com.khun.animalkingdomexplorer.databinding.ListItemAnimalBinding

class AnimalAdapter : Adapter<AnimalAdapter.AnimalViewHolder>() {
    var animals = listOf<Animal>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class AnimalViewHolder(private val binding: ListItemAnimalBinding) :
        ViewHolder(binding.root) {
        fun bind(animal: Animal) {
            binding.tvName.text = animal.name
            binding.tvHabitat.text = animal.habitat
            binding.tvDiet.text = animal.diet
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val binding =
            ListItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalViewHolder(binding)
    }

    override fun getItemCount(): Int = animals.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(animals[position])
    }
}