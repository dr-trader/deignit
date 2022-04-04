package ru.donspb.designit

import android.os.Bundle
import android.text.format.Time
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import ru.donspb.designit.databinding.CountdownLayoutBinding
import ru.donspb.designit.databinding.FragmentFirstScreenBinding
import java.util.concurrent.TimeUnit

class FirstScreenFragment : Fragment(), IFirstScreen {

    private lateinit var binding: FragmentFirstScreenBinding

    private val presenter = FirstScreenPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.top_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mi_search -> { true }
            R.id.mi_filter -> { true }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appBarTextView = TextView(context)
        appBarTextView.apply {
            setText("Hi, User")
            setTextColor(getResources().getColor(R.color.top_text_dark, activity?.theme))
        }
        (activity as AppCompatActivity).supportActionBar?.customView = appBarTextView

        presenter.countdown()
    }

    override fun setTime(timeInMs: Long) {
        val daysStringOne = (TimeUnit.DAYS.toDays(timeInMs) / 10).toString()
        val daysStringTwo = (TimeUnit.DAYS.toDays(timeInMs) % 10).toString()
        val hoursStringOne = ((TimeUnit.HOURS.toHours(timeInMs) % 24) / 10).toString()
        val hoursStringTwo = ((TimeUnit.HOURS.toHours(timeInMs) % 24) % 10).toString()
        val minutesStringOne = ((TimeUnit.MINUTES.toHours(timeInMs) % 60) / 10).toString()
        val minutesStringTwo = ((TimeUnit.MINUTES.toHours(timeInMs) % 60) % 10).toString()
        with(binding.countdownIncluded) {
            countdownTvDays1.text = daysStringOne
            countdownTvDays0.text = daysStringTwo
            countdownTvHours1.text = hoursStringOne
            countdownTvHours0.text = hoursStringTwo
            countdownTvMinutes1.text = minutesStringOne
            countdownTvMinutes0.text = minutesStringTwo
        }
    }
}