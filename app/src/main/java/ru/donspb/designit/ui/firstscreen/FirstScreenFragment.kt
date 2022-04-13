package ru.donspb.designit.ui.firstscreen

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import ru.donspb.designit.R
import ru.donspb.designit.databinding.FragmentFirstScreenBinding
import ru.donspb.designit.model.ClassesModel
import ru.donspb.designit.model.HomeworksModel
import ru.donspb.designit.repository.FakeRepository
import ru.donspb.designit.ui.recyclerview.GenericRecyclerViewAdapter

class FirstScreenFragment : Fragment(), IFirstScreen {

    private lateinit var binding: FragmentFirstScreenBinding
    private val presenter = FirstScreenPresenter(this, FakeRepository())
    private val classesAdapter = GenericRecyclerViewAdapter<ClassesModel>()
    private val homeworksAdapter = GenericRecyclerViewAdapter<HomeworksModel>()

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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.classesRecyclerview.adapter = classesAdapter
        binding.homeworksRecyclerview.adapter = homeworksAdapter
        presenter.countdown()
        presenter.getClasses()
        presenter.getHomeworks()
    }

    override fun setTime(timeInMs: Long) {
        val minute: Long = 1000 * 60
        val hour: Long = minute * 60
        val day: Long = hour * 24
        val days = (timeInMs / day).toInt()
        val hours = ((timeInMs / hour)  % 24).toInt()
        val minutes = ((timeInMs / minute) % 60).toInt()
        with(binding.countdownIncluded) {
            countdownTvDays1.text = (days / 10).toString()
            countdownTvDays0.text = (days % 10).toString()
            countdownTvHours1.text = (hours / 10).toString()
            countdownTvHours0.text = (hours % 10).toString()
            countdownTvMinutes1.text = (minutes / 10).toString()
            countdownTvMinutes0.text = (minutes % 10).toString()
        }
    }

    override fun setClassesData(data: List<ClassesModel>) = classesAdapter.setData(data)

    override fun setHomeworksData(data: List<HomeworksModel>) = homeworksAdapter.setData(data)

    override fun setClassesRVTo(position: Int?) {
        var scrollToPosition: Int
        if (position == null) {
            classesAdapter.addNoClasses()
            scrollToPosition = classesAdapter.itemCount - 1
        } else
            scrollToPosition = position
        binding.classesNumber.text = "$scrollToPosition classes today"
        binding.classesRecyclerview.scrollToPosition(scrollToPosition)
    }


}