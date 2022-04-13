package ru.donspb.designit.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.donspb.designit.ui.fakescreen.FakeScreenFragment
import ru.donspb.designit.ui.firstscreen.FirstScreenFragment
import ru.donspb.designit.ui.secondscreen.SecondScreenFragment

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle, private val tabsQuantity: Int): FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = tabsQuantity

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstScreenFragment()
            1 -> SecondScreenFragment()
            2 -> FakeScreenFragment()
            3 -> FakeScreenFragment()
            else -> FirstScreenFragment()
        }
    }
}