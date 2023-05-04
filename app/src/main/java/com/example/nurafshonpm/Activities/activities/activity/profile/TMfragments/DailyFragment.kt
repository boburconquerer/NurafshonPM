package com.example.nurafshonpm.Activities.activities.activity.profile.TMfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nurafshonpm.Activities.activities.adapters.GoalAdapter
import com.example.nurafshonpm.Activities.activities.modul.Goals
import com.example.nurafshonpm.R
import com.google.android.material.bottomsheet.BottomSheetDialog


class DailyFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_daily, container, false)
        initViews(view)
        return view

    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclePlan_id)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        refreshData(data())


        val textNewPlan = view.findViewById<LinearLayout>(R.id.newPlanLinear_id)
        textNewPlan.setOnClickListener {
            showBottomSheet()
        }
    }

    private fun data(): ArrayList<Goals> {
        val list = ArrayList<Goals>()
        for (i in 1..20){
            list.add(Goals("hehe"))
        }


        return list
    }

    private fun refreshData(data: ArrayList<Goals>) {
        val adapter = GoalAdapter(data)
        recyclerView.adapter = adapter
    }

    private fun showBottomSheet() {
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(R.layout.bottom_daily_plan_sheet)
        val buttonSubmit = bottomSheetDialog.findViewById<AppCompatButton>(R.id.submitButton_id)
        buttonSubmit?.setOnClickListener {
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.show()
    }
}