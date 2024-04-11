package com.khun.sportnewsandinformation.ui.fragment

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.textfield.TextInputEditText
import com.khun.sportnewsandinformation.R
import com.khun.sportnewsandinformation.data.achievementHistories
import com.khun.sportnewsandinformation.data.events
import com.khun.sportnewsandinformation.data.models.AchievementHistory
import com.khun.sportnewsandinformation.data.models.Event
import com.khun.sportnewsandinformation.databinding.FragmentAchievementHistoryBinding
import com.khun.sportnewsandinformation.ui.adapter.AchievementHistoryAdapter
import java.text.SimpleDateFormat
import java.util.Calendar

class AchievementHistoryFragment : Fragment() {
    private var _binding: FragmentAchievementHistoryBinding? = null
    private val binding get() = _binding!!

    private val achievementHistoryAdapter = AchievementHistoryAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAchievementHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvAchievement.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAchievement.adapter = achievementHistoryAdapter

        achievementHistoryAdapter.achievementHistories = achievementHistories

        binding.fab.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Add new History Achievement")

            val view = layoutInflater.inflate(R.layout.dialog_item_layout_add_history, null)
            builder.setView(view)
            val edtEventName = view.findViewById<TextInputEditText>(R.id.edtEventName)
            val edtDate = view.findViewById<TextInputEditText>(R.id.edtDate)
            val edtDescription = view.findViewById<TextInputEditText>(R.id.edtDescription)

            edtDate.setOnClickListener {
                val calendar = Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val day = calendar.get(Calendar.DAY_OF_MONTH)
                DatePickerDialog(requireContext(), { view, year, month, day ->
                    calendar.set(Calendar.YEAR, year)
                    calendar.set(Calendar.MONTH, month)
                    calendar.set(Calendar.DAY_OF_MONTH, day)
                    edtDate.setText(SimpleDateFormat("MMMM dd, YYYY").format(calendar.time))
                }, year, month, day).show()
            }

            builder.setPositiveButton("Add") { dialog, which ->
                val name = edtEventName.text.toString()
                val date = edtDate.text.toString()
                val description = edtDescription.text.toString()

                if (name.isBlank() || date.isBlank() || date.isBlank()) {
                    Toast.makeText(requireContext(), "Please complete all field", Toast.LENGTH_LONG)
                        .show()
                } else {
                    achievementHistories.add(AchievementHistory(name, date, description))
                    achievementHistoryAdapter.achievementHistories = achievementHistories
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