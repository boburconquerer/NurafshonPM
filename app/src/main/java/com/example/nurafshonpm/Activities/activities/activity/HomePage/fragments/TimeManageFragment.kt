package com.example.nurafshonpm.Activities.activities.activity.HomePage.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nurafshonpm.Activities.activities.adapters.TimeManageAdapter
import com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal.AppDatabase
import com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal.PlanData
import com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal.PlanDatabase
import com.example.nurafshonpm.R

class TimeManageFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_time_manager, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {

        recyclerView = view.findViewById(R.id.recycleTime_id)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        fetchData()
    }
    private fun fetchData() {
        val list = ArrayList<PlanData>()
        val data = PlanDatabase.getInstance(requireContext())?.planDao()?.getPlanData()
        for (i in 0 until data?.reversed()!!.size) {
            val goals = data[i]
            list.add(goals)
        }
        refreshData(list)
    }

    private fun refreshData(data:ArrayList<PlanData>) {
        val adapter = TimeManageAdapter(data)
        recyclerView.adapter = adapter
    }


}