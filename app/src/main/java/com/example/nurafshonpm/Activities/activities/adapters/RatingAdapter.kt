package com.example.nurafshonpm.Activities.activities.adapters

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextClock
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nurafshonpm.Activities.activities.model.ModelRating
import com.example.nurafshonpm.R

class RatingAdapter(var list: ArrayList<ModelRating>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rating_item,parent,false)
        return RatingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model: ModelRating = list[position]
        if(holder is RatingViewHolder){
            holder.teacherName.text = model.teacherName
            holder.teacherRating.text = model.teacherRating
            holder.teacherDescription.text = model.description
        }
    }

    inner class RatingViewHolder(view: View): RecyclerView.ViewHolder(view){
        var teacherName: TextView = view.findViewById(R.id.teacherName)
        var teacherRating: TextView = view.findViewById(R.id.teacherRating)
        var teacherDescription: TextView = view.findViewById(R.id.teacherDescription)
    }
}