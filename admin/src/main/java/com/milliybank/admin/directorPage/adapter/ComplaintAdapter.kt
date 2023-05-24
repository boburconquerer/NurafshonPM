package com.milliybank.admin.directorPage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.milliybank.admin.R
import com.milliybank.admin.directorPage.models.DirectorResponseItem

class ComplaintAdapter(var list: ArrayList<DirectorResponseItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.director_item, parent, false)
        return OnComplaintViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model: DirectorResponseItem = list[position]
        if (holder is OnComplaintViewHolder) {
            holder.complaintTitle.text = model.complaint_title
            holder.complaintDesc.text = model.complaint_description
        }
    }

    inner class OnComplaintViewHolder(view: View):RecyclerView.ViewHolder(view){
        val complaintTitle:TextView = view.findViewById(R.id.complaintTitle_id)
        val complaintDesc:TextView = view.findViewById(R.id.complaintDesc_id)
    }
}