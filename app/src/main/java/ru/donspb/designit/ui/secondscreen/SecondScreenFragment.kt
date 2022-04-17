package ru.donspb.designit.ui.secondscreen

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import ru.donspb.designit.R
import ru.donspb.designit.databinding.FragmentSecondScreenBinding
import ru.donspb.designit.model.ClassesModelExtended
import ru.donspb.designit.repository.FakeRepository
import ru.donspb.designit.ui.recyclerview.GenericRecyclerViewAdapter

class SecondScreenFragment : Fragment(), ISecondScreen {

    private lateinit var binding: FragmentSecondScreenBinding
    private val presenter = SecondScreenPresenter(this, FakeRepository())
    private val classesTimeLineAdapter = GenericRecyclerViewAdapter<ClassesModelExtended>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.top_menu_second, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mi_search -> { true }
            R.id.mi_table -> { true }
            R.id.mi_grid -> { true }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.secondScreenRecyclerview.adapter = classesTimeLineAdapter
        presenter.getTimelineData()
    }

    override fun setTimelineData(dataSet: List<ClassesModelExtended>) =
        classesTimeLineAdapter.setData(dataSet)

    override fun setClassesRVTo(position: Int?) {
        if (position != null) binding.secondScreenRecyclerview.scrollToPosition(position)
    }
}