package ru.donspb.designit.ui.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ru.donspb.designit.R
import ru.donspb.designit.databinding.ClassesRecycleItemBinding
import ru.donspb.designit.databinding.HomeworkRecycleItemBinding
import ru.donspb.designit.databinding.TimelineRecycleItemBinding
import ru.donspb.designit.model.ClassesModel
import ru.donspb.designit.model.ClassesModelExtended
import ru.donspb.designit.model.HomeworksModel

class GenericRecyclerViewAdapter<T: Any> : RecyclerView.Adapter<BaseViewHolder<T>>() {

    companion object {
        const val TYPE_CLASSES = 0
        const val TYPE_HOMEWORKS = 1
        const val TYPE_CLASSES_E = 3
        const val CRITICAL_DAYS_LEFT = 2
    }

    private var dataSet: MutableList<T> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<T>?) {
        if (!data.isNullOrEmpty()) {
            dataSet.clear()
            dataSet.addAll(data)
            notifyDataSetChanged()
        }
    }

    fun addNoClasses() {
        dataSet.add(ClassesModel("No classes left",
            "-:-", "-:-", false, true, "infinity") as T)
        notifyItemInserted(itemCount - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return when (viewType) {
            TYPE_CLASSES -> {
                val view = ClassesRecycleItemBinding.inflate(LayoutInflater.from(parent.context),
                    parent, false)
                ClassesRVHolder(view) as BaseViewHolder<T>
            }
            TYPE_HOMEWORKS -> {
                val view = HomeworkRecycleItemBinding.inflate(LayoutInflater.from(parent.context),
                    parent, false)
                HomeworksRVHolder(view) as BaseViewHolder<T>
            }

            TYPE_CLASSES_E -> {
                val view = TimelineRecycleItemBinding.inflate(LayoutInflater.from(parent.context),
                    parent, false)
                TimelineRVHolder(view) as BaseViewHolder<T>
            }
            else -> throw IllegalArgumentException("Invalid viewType in RecycleView adapter")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemViewType(position: Int): Int {
        return when (dataSet[position]) {
            is ClassesModel -> TYPE_CLASSES
            is HomeworksModel -> TYPE_HOMEWORKS
            is ClassesModelExtended -> TYPE_CLASSES_E
            else -> throw IllegalArgumentException("Invalid data type")
        }
    }

    override fun getItemCount(): Int = dataSet.size

    inner class ClassesRVHolder(private val binding: ClassesRecycleItemBinding) :
        BaseViewHolder<ClassesModel>(binding.root) {

        override fun bind(item: ClassesModel) {
            binding.className.text = item.classname
            binding.classTime.text = "${item.timeStart} - ${item.timeEnd}"
            val context = binding.classesRvClassItem.ivIconClasses.context
            binding.classesRvClassItem.ivIconClasses.setImageResource(context.resources.getIdentifier(
                item.icon, "drawable", context.packageName))
            if (item.hasSkype) binding.skypeButton.visibility = View.VISIBLE
            else binding.skypeButton.visibility = View.GONE
        }
    }

    inner class HomeworksRVHolder(private val binding: HomeworkRecycleItemBinding) :
        BaseViewHolder<HomeworksModel>(binding.root) {
        override fun bind(item: HomeworksModel) {
            binding.className.text = item.classname
            binding.homeworkDescription.text = item.description
            val timeLeft = item.timeLeft + binding.homeworkTimeLeft.text
            binding.homeworkTimeLeft.text = timeLeft
            val context = binding.homeworkTimeLeft.context
            if (item.timeLeft.toInt() <= CRITICAL_DAYS_LEFT) binding.homeworkTimeLeft.setTextColor(
                ContextCompat.getColor(context, R.color.dark_red)
            )
            binding.ivIconHw.setImageResource(context.resources.getIdentifier(
                item.icon, "drawable", context.packageName))
        }
    }

    inner class TimelineRVHolder(private val binding: TimelineRecycleItemBinding) :
        BaseViewHolder<ClassesModelExtended>(binding.root) {

        override fun bind(item: ClassesModelExtended) {

            binding.tvTimelineHours.text = item.timeStart + " - " + item.timeEnd

//            binding.className.text = item.classname
//            binding.homeworkDescription.text = item.description
//            val timeLeft = item.timeLeft + binding.homeworkTimeLeft.text
//            binding.homeworkTimeLeft.text = timeLeft
//            val context = binding.homeworkTimeLeft.context
//            if (item.timeLeft.toInt() <= CRITICAL_DAYS_LEFT) binding.homeworkTimeLeft.setTextColor(
//                ContextCompat.getColor(context, R.color.dark_red)
//            )
//            binding.ivIconHw.setImageResource(context.resources.getIdentifier(
//                item.icon, "drawable", context.packageName))
        }
    }
}