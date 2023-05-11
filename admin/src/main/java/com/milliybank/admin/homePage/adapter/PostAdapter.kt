package com.milliybank.admin.homePage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.milliybank.admin.R
import com.milliybank.admin.homePage.modul.PostData

class PostAdapter(var postList: ArrayList<PostData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_page_item, parent, false)
        return OnPostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model: PostData = postList[position]
        if (holder is OnPostViewHolder) {
            holder.newTitle.text = model.newTitle
            holder.newDesc.text = model.newDesc
        }
    }

    inner class OnPostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val newTitle = view.findViewById<TextView>(R.id.newItemTitle_id)
        val newDesc = view.findViewById<TextView>(R.id.newTitleDesc_id)
    }
}