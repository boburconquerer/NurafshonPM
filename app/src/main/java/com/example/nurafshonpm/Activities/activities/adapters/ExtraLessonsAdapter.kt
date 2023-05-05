package com.example.nurafshonpm.Activities.activities.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nurafshonpm.Activities.activities.modul.ExtraLessons
import com.example.nurafshonpm.R
import java.util.concurrent.TimeoutException

class ExtraLessonsAdapter(var list: ArrayList<ExtraLessons>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.educators_item,parent,false)
        return extraData(view)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val model: ExtraLessons = list[position]
        if(holder is extraData){
            holder.extraLessonsDate.text = model.date
            holder.extraLessonsName.text = model.LessonName
            holder.extraLessonsTeacher.text = model.lessonTeacher
            holder.extraLessonsStartTime.text = model.startTime
            holder.extraLessonsEndTime.text = model.endTime
            holder.extraLessonsGroup.text = model.group
        }
    }

    inner class extraData(view: View): RecyclerView.ViewHolder(view){
        var extraLessonsDate: TextView = view.findViewById(R.id.extraLessonsDate)
        var extraLessonsName: TextView = view.findViewById(R.id.extraLessonName)
        var extraLessonsTeacher: TextView = view.findViewById(R.id.extraLessonTeacher)
        var extraLessonsStartTime: TextView = view.findViewById(R.id.extraLessonStartTime)
        var extraLessonsEndTime: TextView = view.findViewById(R.id.extraLessonFinishTime)
        var extraLessonsGroup: TextView = view.findViewById(R.id.extraLessonGroup)
    }


}