package com.example.nurafshonpm.Activities.activities.activity.HomePage.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.nurafshonpm.Activities.activities.activity.EducatorsActivity
import com.example.nurafshonpm.Activities.activities.activity.profile.TimeManagementActivity
import com.example.nurafshonpm.R

class ProfileFragment : Fragment() {
//hehe

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_profile, container, false)

        initViews(view)
        return  view;

    }

    private fun initViews(view: View) {
      openPage(view)

    }


    private fun openPage(view: View){
        val timeManage = view.findViewById<LinearLayout>(R.id.timeManagement)
        timeManage.setOnClickListener {
            val intent = Intent(requireContext() , TimeManagementActivity::class.java)
            startActivity(intent)
        }

        val openEducators = view.findViewById<LinearLayout>(R.id.educators)
        openEducators.setOnClickListener {
            val intent = Intent(requireContext() , EducatorsActivity::class.java)
            startActivity(intent)
        }
    }
}