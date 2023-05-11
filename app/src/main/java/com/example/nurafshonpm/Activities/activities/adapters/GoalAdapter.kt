package com.example.nurafshonpm.Activities.activities.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal.GoalData
import com.example.nurafshonpm.R

class GoalAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val goalLists = ArrayList<GoalData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.goal_layout, parent, false)
        return GoalsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return goalLists.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model: GoalData = goalLists[position]
        if (holder is GoalsViewHolder) {
            holder.goal.text = model.goalNames
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addGoals(goalData: GoalData) {
        goalLists.add(goalData)
        notifyDataSetChanged()
    }

    inner class GoalsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var goal: TextView = view.findViewById(R.id.goalText_id)
    }
}