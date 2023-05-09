package com.example.nurafshonpm.Activities.activities.activity.profile.TMfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.nurafshonpm.Activities.activities.adapters.GoalAdapter
import com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal.AppDatabase
import com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal.GoalData
import com.example.nurafshonpm.Activities.activities.modul.Goals
import com.example.nurafshonpm.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.imageview.ShapeableImageView


class DailyFragment : Fragment() {
    lateinit var deleteIcon: ImageView
    lateinit var recyclerView: RecyclerView
    lateinit var goalAdapter: GoalAdapter
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
        goalAdapter = GoalAdapter()
        recyclerView.adapter = goalAdapter

        fetchData()
        saveData(view)
        //deleteData(view)
        val textNewPlan = view.findViewById<LinearLayout>(R.id.newPlanLinear_id)
        textNewPlan.setOnClickListener {
            showBottomSheet()
        }
    }
    private fun refreshData(data: ArrayList<GoalData>) {
        goalAdapter = GoalAdapter()
        recyclerView.adapter = goalAdapter
    }

    private fun showBottomSheet() {
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(R.layout.bottom_daily_plan_sheet)
        val buttonSubmit = bottomSheetDialog.findViewById<AppCompatButton>(R.id.createPlanButton_id)
        buttonSubmit?.setOnClickListener {
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.show()
    }

    private fun fetchData() {
        val data =  AppDatabase.getInstance(requireContext())?.goalDao()?.getAll()
        for (i in 0 until data?.reversed()!!.size){
            val goals = data[i]
            goalAdapter.addGoals(goals)
        }

    }

    private fun saveData(view: View) {
        val submitButton: AppCompatButton = view.findViewById(R.id.submitGoal_id)
        submitButton.setOnClickListener {
            val goalEditText: EditText = view.findViewById(R.id.goalField_id)
            val textOfGoal = goalEditText.text.toString().trim()
            val goalData = GoalData()
            goalData.goalNames = textOfGoal
            goalAdapter.addGoals(goalData)
            AppDatabase.getInstance(requireContext())?.goalDao()?.insert(goalData)
            Toast.makeText(requireContext(), "Saved", Toast.LENGTH_LONG).show()
        }


    }
    private fun deleteData(view: View){
        val goalData = GoalData()
        deleteIcon= view.findViewById(R.id.deleteIcon_id)
        deleteIcon.setOnClickListener {
            goalData.id?.let { it1 ->
                AppDatabase.getInstance(requireContext())?.goalDao()?.delete(
                    it1
                )
            }
        }
    }
}