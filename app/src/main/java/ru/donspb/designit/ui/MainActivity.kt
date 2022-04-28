package ru.donspb.designit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import ru.donspb.designit.R
import ru.donspb.designit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val appActionBar = supportActionBar
        appActionBar?.apply {
            setDisplayShowTitleEnabled(false)
            setDisplayShowCustomEnabled(true)
        }

        val tabsNames = arrayListOf(
            getString(R.string.mi_home_name),
            getString(R.string.mi_classes_name),
            getString(R.string.mi_list_name),
            getString(R.string.mi_fav_name))

        val tabLayout = binding.tabsLayout
        val viewPager = binding.viewpagerMain
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle, tabsNames.size)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = getString(R.string.mi_home_name)
                    tab.icon = AppCompatResources.getDrawable(this, R.drawable.ic_home)
                }
                1 -> {
                    tab.text = getString(R.string.mi_classes_name)
                    tab.icon = AppCompatResources.getDrawable(this, R.drawable.ic_calendar)
                }
                2 -> {
                    tab.text = getString(R.string.mi_list_name)
                    tab.icon = AppCompatResources.getDrawable(this, R.drawable.ic_table)
                }
                3 -> {
                    tab.text = getString(R.string.mi_fav_name)
                    tab.icon = AppCompatResources.getDrawable(this, R.drawable.ic_star)
                }
            }
        }.attach()
    }
}