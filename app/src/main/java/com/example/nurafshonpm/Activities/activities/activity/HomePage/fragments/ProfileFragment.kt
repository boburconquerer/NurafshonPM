package com.example.nurafshonpm.Activities.activities.activity.HomePage.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.nurafshonpm.Activities.activities.activity.profile.TimeManagementActivity
import com.example.nurafshonpm.R
import com.google.android.material.bottomsheet.BottomSheetDialog

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        administration(view)
        director(view)

        teacher(view)

        educator(view)


    }
    private fun administration(view: View) {

        val administration = view.findViewById<LinearLayout>(R.id.adminstration)

        administration.setOnClickListener{
            bottomSheetDialog(view)
        }
    }
    private fun director(view: View) {

        val director = view.findViewById<LinearLayout>(R.id.director)

        director.setOnClickListener{
            bottomSheetDialog(view)
        }
    }

    private fun teacher(view: View) {

        var teacher = view.findViewById<LinearLayout>(R.id.teacher)

        teacher.setOnClickListener{
            bottomSheetRating()
        }
    }

    private fun educator(view: View) {
            val openEducators = view.findViewById<LinearLayout>(R.id.educators)
            openEducators.setOnClickListener {
                val intent = Intent(requireContext() , EducatorsFragment::class.java)
                startActivity(intent)
            }


    }
    private fun bottomSheetDialog(view: View) {
        val bottomSheet = BottomSheetDialog(requireContext())
        bottomSheet.setContentView(R.layout.bottomsheet_fragment)
        bottomSheet.show()



        val openEducators = view.findViewById<LinearLayout>(R.id.educators)
        openEducators?.setOnClickListener {
            val intent = Intent(requireContext() , EducatorsFragment::class.java)
            startActivity(intent)
        }
    }
    private fun bottomSheetRating() {
        val bottomSheet = BottomSheetDialog(requireContext())

        bottomSheet.setContentView(R.layout.activity_bottom_sheet_rating)
        bottomSheet.show()


        val openEducators = view?.findViewById<LinearLayout>(R.id.educators)
        openEducators?.setOnClickListener {
            val intent = Intent(requireContext() , EducatorsFragment::class.java)
            startActivity(intent)
        }

    }
}