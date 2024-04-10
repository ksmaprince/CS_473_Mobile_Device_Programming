package com.khun.sportnewsandinformation.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.khun.sportnewsandinformation.data.models.AchievementHistory
import com.khun.sportnewsandinformation.databinding.ListItemAchievementHistoryBinding

class AchievementHistoryAdapter :
    Adapter<AchievementHistoryAdapter.AchievementHistoryViewHolder>() {
    var achievementHistories = arrayListOf<AchievementHistory>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class AchievementHistoryViewHolder(val binding: ListItemAchievementHistoryBinding) :
        ViewHolder(binding.root) {
        fun bind(achievementHistory: AchievementHistory) {
            binding.tvName.text = achievementHistory.name
            binding.tvDate.text = achievementHistory.date
            binding.tvDescription.text = achievementHistory.description
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AchievementHistoryViewHolder {
        val binding =
            ListItemAchievementHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return AchievementHistoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return achievementHistories.size
    }

    override fun onBindViewHolder(holder: AchievementHistoryViewHolder, position: Int) {
        holder.bind(achievementHistories[position])
    }
}