package com.khun.sportnewsandinformation.ui.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.textfield.TextInputEditText
import com.khun.sportnewsandinformation.R
import com.khun.sportnewsandinformation.data.models.News
import com.khun.sportnewsandinformation.data.models.Sport
import com.khun.sportnewsandinformation.data.newsList
import com.khun.sportnewsandinformation.data.sports
import com.khun.sportnewsandinformation.databinding.FragmentNewsBinding
import com.khun.sportnewsandinformation.ui.adapter.NewsAdapter

class NewsFragment : Fragment() {
    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    private val newsAdapter = NewsAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvNews.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNews.adapter = newsAdapter

        newsAdapter.news = newsList

        binding.fab.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Add new News")

            val view = layoutInflater.inflate(R.layout.dialog_item_layout_add_news, null)
            builder.setView(view)
            val edtImageUrl = view.findViewById<TextInputEditText>(R.id.edtImageUrl)
            val edtTitle = view.findViewById<TextInputEditText>(R.id.edtTitle)
            val edtDescription = view.findViewById<TextInputEditText>(R.id.edtDescription)

            builder.setPositiveButton("Add"){ dialog, which ->
                val imageUrl = edtImageUrl.text.toString()
                val title = edtTitle.text.toString()
                val description = edtDescription.text.toString()
                if (imageUrl.isBlank() || title.isBlank() || description.isBlank()){
                    Toast.makeText(requireContext(), "Please complete all field", Toast.LENGTH_LONG).show()
                }else{
                    newsList.add(News(title, description, imageUrl))
                    newsAdapter.news = newsList
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