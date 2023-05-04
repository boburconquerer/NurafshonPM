package com.example.nurafshonpm.Activities.activities.activity.HomePage.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nurafshonpm.Activities.activities.adapters.TimeManageAdapter
import com.example.nurafshonpm.Activities.activities.modul.Planning
import com.example.nurafshonpm.R

class TimeManageFragment : Fragment() {
    private lateinit var recyclerView:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_time_manager, container, false)

        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recycleTime_id)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        refreshData(data())


    }

    private fun data(): ArrayList<Planning> {
        val list = ArrayList<Planning>()
        list.add(Planning("I need to work out", "top 3 national universities starting their exams on august! " +
                "To pass you need to be genius...top 3 national universities starting their exams on august! "))
        list.add(Planning("I need to work out", "top 3 national universities starting their exams on august! " +
                "To pass you need to be genius...top 3 national universities starting their exams on august! "))
        list.add(Planning("I need to work out", "top 3 national universities starting their exams on august! " +
                "To pass you need to be genius...top 3 national universities starting their exams on august! "))
        list.add(Planning("I need to work out", "top 3 national universities starting their exams on august! " +
                "To pass you need to be genius...top 3 national universities starting their exams on august! "))
        return list
    }

    private fun refreshData(data: ArrayList<Planning>) {
        val adapter = TimeManageAdapter(data)
        recyclerView.adapter = adapter
    }

}