package com.example.nurafshonpm.Activities.activities.activity.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.nurafshonpm.Activities.activities.activity.profile.TMfragments.DailyFragment
import com.example.nurafshonpm.Activities.activities.activity.profile.TMfragments.tasksfragment
import com.example.nurafshonpm.Activities.activities.adapters.TimeManagementAdapter
import com.example.nurafshonpm.R
import com.google.android.material.tabs.TabLayout

class TimeManagementActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_management)


        initView()

    }

    private fun initView() {
        val tabLayout = findViewById<TabLayout>(R.id.timeTbLayout_id)
        val viewPager = findViewById<ViewPager>(R.id.timeViewPager_id)
        val adapter = TimeManagementAdapter(supportFragmentManager)
        adapter.addFragment(DailyFragment(), "Daily plan")
        adapter.addFragment(tasksfragment(), "Schedule")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }


}