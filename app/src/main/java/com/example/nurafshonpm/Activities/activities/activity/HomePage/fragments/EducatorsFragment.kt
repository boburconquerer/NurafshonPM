package com.example.nurafshonpm.Activities.activities.activity.HomePage.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nurafshonpm.R


class EducatorsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_educators, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {

    }
}