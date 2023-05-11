package com.milliybank.admin.homePage.fragments

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milliybank.admin.R
import com.milliybank.admin.homePage.adapter.PostAdapter
import com.milliybank.admin.homePage.modul.PostData
import org.w3c.dom.Text


class HomeAdminFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home_admin, container, false)

        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclePost_id)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        refreshData(data())

    }

    private fun data(): ArrayList<PostData> {
        val list = ArrayList<PostData>()
        for (i in 1..10){
            list.add(PostData("Good title","IT"))
        }
        return list
    }

    private fun refreshData(data: ArrayList<PostData>) {
        val adapter = PostAdapter(data)
        recyclerView.adapter = adapter
    }
}