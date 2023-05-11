package com.milliybank.admin.educatorPage.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milliybank.admin.R
import com.milliybank.admin.educatorPage.adapter.HobbyAdapter
import com.milliybank.admin.educatorPage.modul.HobbyData
import com.milliybank.admin.homePage.adapter.PostAdapter
import com.milliybank.admin.homePage.modul.PostData


class EducatorAdminFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_educator_admin, container, false)
        initViews(view)
        return view


    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recycleHobbies_id)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        refreshData(data())
    }

    private fun data(): ArrayList<HobbyData> {
        val list = ArrayList<HobbyData>()
        for (i in 1..10){
            list.add(
                HobbyData("17/05/2023","Android Development",
                "Alisher Daminov", "17:00", "22:00",
            "GRADE 10")
            )
        }
        return list
    }


    private fun refreshData(data: ArrayList<HobbyData>) {
        val adapter = HobbyAdapter(data)
        recyclerView.adapter = adapter
    }
}