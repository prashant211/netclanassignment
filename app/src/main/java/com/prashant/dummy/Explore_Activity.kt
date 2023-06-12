package com.prashant.dummy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import java.lang.IllegalArgumentException

@Suppress("DEPRECATION")
class Explore_Activity : AppCompatActivity() {
    lateinit var bottomNavigation: BottomNavigationView
    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore)
        bottomNavigation = findViewById(R.id.bottom_navigation)
        bottomNavigation.selectedItemId = R.id.explore
        navigation()

        viewPager = findViewById(R.id.view_pager)
        val adapter = MyPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        tabLayout = findViewById(R.id.tab_layout)
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.addOnTabSelectedListener(TabLayoutOnTabSelectedListener())

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        // Set custom view for each tab item
        for (i in 0 until tabLayout.tabCount) {
            val tab = tabLayout.getTabAt(i)
            tab?.customView = adapter.getTabView(i)
        }
    }

    inner class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        private val titles = arrayOf("Personal", "Business", "Merchant")

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> Personal()
                1 -> Business()
                2 -> Merchant()
                else -> throw IllegalArgumentException("Invalid Tab Position")
            }
        }

        override fun getCount(): Int {
            return titles.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }
        fun getTabView(position: Int): View {
            val view = LayoutInflater.from(this@Explore_Activity).inflate(R.layout.custom_tab, null)
            val title = view.findViewById<TextView>(R.id.tab_title)
            title.text = titles[position]
            return view
        }
    }

    inner class TabLayoutOnTabSelectedListener : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) {
            val customView = tab.customView
            val title = customView?.findViewById<TextView>(R.id.tab_title)
            title?.setTextColor(resources.getColor(android.R.color.white))
        }

        override fun onTabUnselected(tab: TabLayout.Tab) {
            val customView = tab.customView
            val title = customView?.findViewById<TextView>(R.id.tab_title)
            title?.setTextColor(resources.getColor(android.R.color.darker_gray))
        }

        override fun onTabReselected(tab: TabLayout.Tab) {}
    }

    private fun navigation() {
        bottomNavigation.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.check -> {
                    val intent = Intent(this@Explore_Activity, MainActivity::class.java)
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    startActivity(intent)
                    finish()
                }
                R.id.explore -> {
                    return@setOnItemSelectedListener true
                }
                else -> {

                }
            }
            return@setOnItemSelectedListener false

        }

    }
}
