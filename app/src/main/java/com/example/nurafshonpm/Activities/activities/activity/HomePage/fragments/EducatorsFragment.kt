package com.example.nurafshonpm.Activities.activities.activity.HomePage.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.nurafshonpm.Activities.activities.adapters.ExtraLessonsAdapter
import com.example.nurafshonpm.Activities.activities.modul.ExtraLessons
import com.example.nurafshonpm.R


class EducatorsFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_educators, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.EducatorsFragment)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        refreshData(data())
    }

    private fun data(): ArrayList<ExtraLessons> {
        val list = ArrayList<ExtraLessons>()
        for (i in 1..10){
            list.add(ExtraLessons("03.02.2023","IT","Alisher Daminov","17:00","21:00","7 Green"))
        }
        return list
    }

    private fun refreshData(data: ArrayList<ExtraLessons>) {
        val adapter = ExtraLessonsAdapter(data)
        recyclerView.adapter = adapter
    }
}