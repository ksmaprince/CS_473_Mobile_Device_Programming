package com.khun.sportnewsandinformation.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.khun.sportnewsandinformation.data.models.Sport
import com.khun.sportnewsandinformation.databinding.ListItemSportsBinding

class SportsAdapter: Adapter<SportsAdapter.SportsViewHolder>() {
    var sports = listOf<Sport>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    inner class SportsViewHolder(val binding: ListItemSportsBinding): ViewHolder(binding.root){
        fun bind(sport: Sport){
            binding.tvType.text = sport.type
            binding.tvName.text = sport.name
            binding.tvInstruction.text = sport.instruction
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        val binding = ListItemSportsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SportsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return sports.size
    }

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        holder.bind(sports[position])
    }
}