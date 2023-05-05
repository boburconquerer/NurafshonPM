package com.example.nurafshonpm.Activities.activities.activity.profile.TMfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nurafshonpm.Activities.activities.adapters.GoalAdapter
import com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal.AppDatabase
import com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal.GoalData
import com.example.nurafshonpm.Activities.activities.modul.Goals
import com.example.nurafshonpm.R
import com.google.android.material.bottomsheet.BottomSheetDialog


class DailyFragment : Fragment() {
    private val listOfGoals = ArrayList<GoalData>()
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
        fetchData()
        saveData(view)
        val textNewPlan = view.findViewById<LinearLayout>(R.id.newPlanLinear_id)
        textNewPlan.setOnClickListener {
            showBottomSheet()
        }
    }
    private fun refreshData(data: ArrayList<GoalData>) {
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

    private fun fetchData() {
        var fetchDataGoal = AppDatabase.getInstance(requireContext())?.goalDao()?.getAll()
        if (fetchDataGoal != null) {
            listOfGoals.add(fetchDataGoal)
        }
        refreshData(listOfGoals)
    }

    private fun saveData(view: View) {
        val submitButton: AppCompatButton = view.findViewById(R.id.submitGoal_id)
        submitButton.setOnClickListener {
            val goalEditText: EditText = view.findViewById(R.id.goalField_id)
            val textOfGoal = goalEditText.text.toString().trim()
            val goalData = GoalData()
            goalData.goalNames = textOfGoal
            AppDatabase.getInstance(requireContext())?.goalDao()?.insert(goalData)
        }


    }
}