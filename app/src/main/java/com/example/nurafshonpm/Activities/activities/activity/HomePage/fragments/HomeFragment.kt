package com.example.nurafshonpm.Activities.activities.activity.HomePage.fragments

import android.icu.lang.UCharacter.VerticalOrientation
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nurafshonpm.Activities.activities.adapters.AdapterHomePage
import com.example.nurafshonpm.Activities.activities.model.ModelHomePage
import com.example.nurafshonpm.R

class HomeFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewHomePage)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        refreshData(data())


    }

    private fun data(): ArrayList<ModelHomePage> {
        val list = ArrayList<ModelHomePage>()
        for (i in 1..20) {

            list.add(
                ModelHomePage(
                    R.drawable.image,
                    "16.02.2023",
                    "The start of the exams",
                    "top 3 national universities starting their exams on august! To pass you need to be genius...top 3 national universities starting their exams on august! To pass you need to be genius To pass you need to be genius...top 3 national universities starting their exams on august! To pass you need to be genius..."
                )
            )
        }
        return list
    }

    private fun refreshData(data: ArrayList<ModelHomePage>) {
        val adapter = AdapterHomePage(data)
        recyclerView.adapter = adapter
    }
}