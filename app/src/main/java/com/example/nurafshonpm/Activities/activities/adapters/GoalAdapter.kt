package com.example.nurafshonpm.Activities.activities.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nurafshonpm.Activities.activities.activity.profile.TMfragments.DailyFragment
import com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal.GoalData
import com.example.nurafshonpm.R

class GoalAdapter(
    private val goalLists: ArrayList<GoalData>, private val context: DailyFragment
) : RecyclerView.Adapter<GoalAdapter.GoalsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.goal_layout, parent, false)
        return GoalsViewHolder(view)
    }

    override fun onBindViewHolder(holder: GoalsViewHolder, position: Int) {
        holder.goalText.text = goalLists[position].goalNames

    }

    override fun getItemCount(): Int {
        return goalLists.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addGoals(goalData: GoalData) {
        goalLists.add(goalData)
        notifyDataSetChanged()
    }

    inner class GoalsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val goalText: TextView = view.findViewById(R.id.goalText_id)
    }
}