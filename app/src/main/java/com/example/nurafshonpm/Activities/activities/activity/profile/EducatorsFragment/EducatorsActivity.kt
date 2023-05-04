package com.example.nurafshonpm.Activities.activities.activity.profile.EducatorsFragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.nurafshonpm.Activities.activities.fragmentAdapter.FragmentAdapter
import com.example.nurafshonpm.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class EducatorsActivity : AppCompatActivity() {

    lateinit var menuItem: MenuItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_educators)

        initViews()
    }

    private fun initViews() {
        onClicked()
        fragmentData()
    }


    private fun onClicked() {
        val fragmentAdapter = FragmentAdapter(fragmentData(), supportFragmentManager)
        val viewActivity = findViewById<ViewPager>(R.id.educatorsSchedule)
        val bottomBar = findViewById<BottomNavigationView>(R.id.educatorsFragment)
        viewActivity.adapter = fragmentAdapter

        bottomBar.setOnNavigationItemSelectedListener { bottomMenu ->
            when(bottomMenu.itemId){
                R.id.lessons->{
                    viewActivity.currentItem=0
                }
                R.id.sports->{
                    viewActivity.currentItem=1
                }
            }
            true
        }
        viewActivity.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (::menuItem.isInitialized){
                    menuItem.isChecked = false
                }else{
                    bottomBar.menu.getItem(0).isChecked = false
                }
                bottomBar.menu.getItem(position).isChecked = false
                menuItem = bottomBar.menu.getItem(position)
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
    }

    private fun fragmentData(): ArrayList<Fragment> {
        return arrayListOf(
            Lessons(),
            Sports()
        )

    }
}