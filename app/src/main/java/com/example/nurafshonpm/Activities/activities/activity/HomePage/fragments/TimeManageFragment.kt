package com.example.nurafshonpm.Activities.activities.activity.HomePage.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nurafshonpm.Activities.activities.adapters.TimeManageAdapter
import com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal.PlanData
import com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal.PlanDatabase
import com.example.nurafshonpm.R
import com.google.android.material.bottomsheet.BottomSheetDialog

class TimeManageFragment : Fragment() {
    private lateinit var recyclerView:RecyclerView
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
        recyclerView = view.findViewById(R.id.recycleTime_id)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        planAdapter = TimeManageAdapter()
        recyclerView.adapter = planAdapter
        fetchData()
        saveData(view)

    }
    private fun fetchData() {
        val data =  PlanDatabase.getInstance(requireContext())?.planDao()?.getAll()
        for (i in 0 until data?.reversed()!!.size){
            val plans = data[i]
            planAdapter.addPlans(plans)
        }

    }

    private fun saveData(view: View) {
        val planSheetDialog = BottomSheetDialog(requireContext())
        planSheetDialog.setContentView(R.layout.bottom_daily_plan_sheet)
        val createPlanButton: Button? = planSheetDialog.findViewById(R.id.createPlanButton_id)
        createPlanButton?.setOnClickListener {

            val titleEditTExt: EditText? = planSheetDialog.findViewById(R.id.yourPlan_id)
            val descEditText: EditText? = planSheetDialog.findViewById(R.id.planDescription_id)
            val textOfTitle = titleEditTExt?.text.toString().trim()
            val textOfDesc = descEditText?.text.toString().trim()
            val planData = PlanData()
            planData.title = textOfTitle
            planData.description = textOfDesc
            planAdapter.addPlans(planData)
            PlanDatabase.getInstance(requireContext())?.planDao()?.insert(planData)
            Toast.makeText(requireContext(), "Saved", Toast.LENGTH_LONG).show()
        }


    }

}