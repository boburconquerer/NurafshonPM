package com.example.nurafshonpm.Activities.activities.activity.HomePage.fragments

import android.os.Bundle
import android.view.Display.Mode
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nurafshonpm.Activities.activities.adapters.RatingAdapter
import com.example.nurafshonpm.Activities.activities.model.ModelRating
import com.example.nurafshonpm.R

class RatingPageFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_rating, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewRating)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        refreshData(data())

    }

    private fun data(): ArrayList<ModelRating> {
        val list = ArrayList<ModelRating>()
        for (i in 1..20){
            list.add(ModelRating("Alisher Daminov","5","good teacher, instructs students to junior stage in app development.good teacher, instructs students to junior stage in app development.good teacher, instructs students to junior stage in app development.good teacher, instructs students to junior stage in app development.good teacher, instructs students to junior stage in app development."))
        }
        return list
    }

    private fun refreshData(data: ArrayList<ModelRating>) {
        val adapter = RatingAdapter(data)
        recyclerView.adapter = adapter
    }

}