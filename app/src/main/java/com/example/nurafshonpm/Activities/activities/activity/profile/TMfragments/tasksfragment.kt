package com.example.nurafshonpm.Activities.activities.activity.profile.TMfragments

import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.nurafshonpm.R

class tasksfragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_tasksfragment, container, false)

        initViews(view)
        return view

    }

    private fun initViews(view:View) {
//        var date = view.findViewById<TextView>(R.id.date)
//        val calendar = Calendar.getInstance()
//
//        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
//        val month = calendar.get(Calendar.MONTH) + 1
//        val year = calendar.get(Calendar.YEAR)
//
//        val dateStr = "$dayOfMonth/$month/$year"
//        date.text = dateStr
//        Log.d("MyApp", "Bugun: $dateStr")





//        val calendar = Calendar.getInstance()
//        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
//        val month = calendar.get(Calendar.MONTH) + 1 // 0-dan boshlanadi, shuning uchun +1 qo'shamiz
//        val year = calendar.get(Calendar.YEAR)
//
//        val dateStr = "$dayOfMonth/$month/$year"
//        val calendar = Calendar.getInstance()
//
//        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
//        val month = calendar.get(Calendar.MONTH) + 1 // 0-dan boshlanadi, shuning uchun +1 qo'shamiz
//        val year = calendar.get(Calendar.YEAR)
//
//        val dateStr = "$dayOfMonth/$month/$year"
//
//        Log.d("MyApp", "Bugun: $dateStr")

    }
}