package com.milliybank.admin.homePage.fragments

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.milliybank.admin.R
import org.w3c.dom.Text


class HomeAdminFragment : Fragment() {


    private lateinit var selectedDate: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home_admin, container, false)

        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        var textView = view.findViewById<TextView>(R.id.chooseDate_id)
        var dateView = view.findViewById<TextView>(R.id.dateView_id)
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(requireContext(), { _, year, month, dayOfMonth ->

            selectedDate = "$dayOfMonth/${month + 1}/$year"

            dateView.text = " $selectedDate"
        }, year, month, day)

        textView.setOnClickListener {
            datePickerDialog.show()
        }
    }

}