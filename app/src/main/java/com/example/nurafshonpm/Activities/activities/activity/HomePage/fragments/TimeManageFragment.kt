package com.example.nurafshonpm.Activities.activities.activity.HomePage.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nurafshonpm.Activities.activities.adapters.TimeManageAdapter
import com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal.AppDatabase
import com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal.PlanData
import com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal.PlanDatabase
import com.example.nurafshonpm.R

class TimeManageFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var planAdapter: TimeManageAdapter
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
        val data = ArrayList<PlanData>()
        recyclerView = view.findViewById(R.id.recycleTime_id)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        planAdapter = TimeManageAdapter(data)
        recyclerView.adapter = planAdapter
        fetchData()


    }

    private fun fetchData() {
        var data = PlanDatabase.getInstance(requireContext())?.planDao()?.getAll()
        for (i in 0 until data?.reversed()!!.size) {
            var plans = data[i]
            planAdapter.addPlans(plans)
        }

    }

    private fun refreshData(data: ArrayList<PlanData>) {
        planAdapter = TimeManageAdapter(data)
        recyclerView.adapter = planAdapter
    }


}