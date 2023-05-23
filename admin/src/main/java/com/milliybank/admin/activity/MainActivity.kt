package com.milliybank.admin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.milliybank.admin.Admin
import com.milliybank.admin.Director
import com.milliybank.admin.R
import com.milliybank.admin.educatorPage.fragment.EducatorAdminFragment
import com.milliybank.admin.homePage.adapter.FragmentAdapter
import com.milliybank.admin.homePage.fragments.HomeAdminFragment

// hello
class MainActivity : AppCompatActivity() {

    private lateinit var menuItem: MenuItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        onClicked()
        fragmentData()
    }

    private fun fragmentData(): ArrayList<Fragment> {
        return arrayListOf(
            HomeAdminFragment(),
            Admin(),
            EducatorAdminFragment(),
            Director()


        )
    }

    private fun onClicked() {
        val fragmentAdapter = FragmentAdapter(fragmentData(), supportFragmentManager)
        val viewHomeActivity = findViewById<ViewPager>(R.id.homeViewPage_id)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation_id)
        viewHomeActivity.adapter = fragmentAdapter

        bottomNavigation.setOnNavigationItemSelectedListener { bottomMenu ->
            when(bottomMenu.itemId) {
                R.id.menu_homeFragment_id-> {
                    viewHomeActivity.currentItem= 0
                }
                R.id.menu_adminFragment_id-> {
                    viewHomeActivity.currentItem= 1
                }

                R.id.menu_educatorsFragment_id -> {
                    viewHomeActivity.currentItem= 2
                }

                R.id.menu_directorFragment_id-> {
                    viewHomeActivity.currentItem= 3
                }

            }
            true
        }
        viewHomeActivity.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
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
                    bottomNavigation.menu.getItem(0).isChecked = false
                }
                bottomNavigation.menu.getItem(position).isChecked = true
                menuItem = bottomNavigation.menu.getItem(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })
    }
}