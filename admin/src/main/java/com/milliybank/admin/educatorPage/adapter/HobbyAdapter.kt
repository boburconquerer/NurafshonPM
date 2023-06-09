package com.milliybank.admin.educatorPage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.milliybank.admin.R
import com.milliybank.admin.educatorPage.models.EducatorsResponseGetItem

class HobbyAdapter(var hobbyList: ArrayList<EducatorsResponseGetItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.educators_item, parent, false)
        return OnHobbyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbyList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model: EducatorsResponseGetItem = hobbyList[position]
        if (holder is OnHobbyViewHolder) {
            holder.startDate.text = model.start_date
            holder.lessonName.text = model.name
            holder.teacherName.text = model.teacher
            holder.starting.text = model.start_time
            holder.ending.text = model.end_time
            holder.className.text = model.group
        }
    }

    inner class OnHobbyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val startDate:TextView = view.findViewById(R.id.extraLessonDate)
        val lessonName:TextView = view.findViewById(R.id.extraLessonName)
        val teacherName:TextView = view.findViewById(R.id.extraLessonTeacher)
        val starting:TextView = view.findViewById(R.id.extraLessonStartTime)
        val ending:TextView = view.findViewById(R.id.extraLessonFinishTime)
        val className:TextView = view.findViewById(R.id.extraLessonGroup)



    }
}