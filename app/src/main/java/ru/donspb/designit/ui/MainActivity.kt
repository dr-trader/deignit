package ru.donspb.designit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsetsController
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
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

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val index = tab?.position
                if (index != null) {
                    tab.text = tabsNames[index]
                    tab.icon?.setTint(getColor(R.color.bot_button_color_selected))
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.text = ""
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.icon = AppCompatResources.getDrawable(this, R.drawable.ic_home)
                }
                1 -> {
                    tab.icon = AppCompatResources.getDrawable(this, R.drawable.ic_calendar)
                }
                2 -> {
                    tab.icon = AppCompatResources.getDrawable(this, R.drawable.ic_table)
                }
                3 -> {
                    tab.icon = AppCompatResources.getDrawable(this, R.drawable.ic_star)
                }
            }
        }.attach()
    }

    private fun hideSystemBars() {
        val windowInsetsController = ViewCompat.getWindowInsetsController(window.decorView) ?: return
        windowInsetsController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }
}