package com.khun.sportnewsandinformation.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.khun.sportnewsandinformation.data.models.News
import com.khun.sportnewsandinformation.databinding.ListItemNewsBinding

class NewsAdapter : Adapter<NewsAdapter.NewsViewHolder>() {
    var news = arrayListOf<News>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class NewsViewHolder(val binding: ListItemNewsBinding) : ViewHolder(binding.root) {
        fun bind(news: News) {
            Glide.with(binding.root)
                .load(news.imageUrl)
                .into(binding.ivNewImage)

            binding.tvTitle.text = news.title
            binding.tvDescription.text = news.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding =
            ListItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(news[position])
    }
}