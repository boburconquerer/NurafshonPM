package com.example.nurafshonpm.Activities.activities.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal.PlanData
import com.example.nurafshonpm.R

class TimeManageAdapter(private val planList: ArrayList<PlanData>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.daily_plan_item, parent, false)
        return PlanViewHolder(view)
    }

    override fun getItemCount(): Int {
        return planList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val plans: PlanData = planList[position]
        if (holder is PlanViewHolder) {
            holder.planTitle.text = plans.title
            holder.planDesc.text = plans.description
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun addPlans(planData: PlanData) {
        planList.add(planData)
        notifyDataSetChanged()
    }

    inner class PlanViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val planTitle: TextView = view.findViewById(R.id.title_id)
        val planDesc: TextView = view.findViewById(R.id.descPlan_id)
    }
}