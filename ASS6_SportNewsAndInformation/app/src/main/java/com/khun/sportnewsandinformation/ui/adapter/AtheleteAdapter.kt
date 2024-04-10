package com.khun.sportnewsandinformation.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khun.sportnewsandinformation.data.models.Athelete
import com.khun.sportnewsandinformation.databinding.ListItemAtheleteBinding

class AtheleteAdapter : RecyclerView.Adapter<AtheleteAdapter.AtheleteViewHolder>() {
    var atheletes = listOf<Athelete>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class AtheleteViewHolder(val binding: ListItemAtheleteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(athelete: Athelete) {
            binding.tvName.text = "Name: ${athelete.name}"
            binding.tvSportName.text ="Sport: ${athelete.sportName}"
            binding.tvCountry.text = "Country: ${athelete.country}"
            binding.tvBestPerformance.text = "Personal Best: ${athelete.bestPerformance}"
            binding.tvMedals.text = "Medals Awarded: ${athelete.medal}"
            binding.tvFacts.text = "Facts: ${athelete.fact}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AtheleteViewHolder {
        val binding =
            ListItemAtheleteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AtheleteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return atheletes.size
    }

    override fun onBindViewHolder(holder: AtheleteViewHolder, position: Int) {
        holder.bind(atheletes[position])
    }
}