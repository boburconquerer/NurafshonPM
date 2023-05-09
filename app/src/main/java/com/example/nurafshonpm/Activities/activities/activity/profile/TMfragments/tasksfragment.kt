package com.example.nurafshonpm.Activities.activities.activity.profile.TMfragments

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.nurafshonpm.R

class tasksfragment : Fragment() {

    private lateinit var selectedDate: String
    private lateinit var selectedDate2: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_tasksfragment, container, false)

        initViews(view)
        return view

    }

    private fun initViews(view: View) {


        var textView = view.findViewById<TextView>(R.id.textView)
        var textView2 = view.findViewById<TextView>(R.id.textView2)
        var korsatiladiganJoy = view.findViewById<TextView>(R.id.korsatiladiganJoy)
        var korsatiladiganJoy2 = view.findViewById<TextView>(R.id.korsatiladiganJoy2)
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(requireContext(), { _, year, month, dayOfMonth ->

            selectedDate = "$dayOfMonth/${month + 1}/$year"

            korsatiladiganJoy.text = " $selectedDate"
        }, year, month, day)
        val datePickerDialog2 = DatePickerDialog(requireContext(), { _, year, month, dayOfMonth ->

            selectedDate2 = "$dayOfMonth/${month + 1}/$year"

            korsatiladiganJoy2.text = "$selectedDate2"
        }, year, month, day)


        textView.setOnClickListener {
            datePickerDialog.show()
        }
        textView2.setOnClickListener {
            datePickerDialog2.show()
        }

    }
}