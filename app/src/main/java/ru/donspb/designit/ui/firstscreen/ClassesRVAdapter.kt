package ru.donspb.designit.ui.firstscreen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.donspb.designit.databinding.ClassesRecycleItemBinding
import ru.donspb.designit.model.ClassesModel

class ClassesRVAdapter() :
    RecyclerView.Adapter<ClassesRVAdapter.ClassesRVHolder>() {

    private var dataSet: List<ClassesModel> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<ClassesModel>?) {
        if (!data.isNullOrEmpty()) {
            dataSet = data + listOf(ClassesModel("No more classes today",
            "-:-", "-:-", false, true, "infinity"))
            notifyDataSetChanged()
        }
    }

    inner class ClassesRVHolder(private val binding: ClassesRecycleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun setClassesInfo(data: ClassesModel) {
                binding.className.text = data.classname
                binding.classTime.text = "${data.timeStart} - ${data.timeEnd}"
                val context = binding.ivIconClasses.context
                binding.ivIconClasses.setImageResource(context.resources.getIdentifier(
                    data.icon, "drawable", context.packageName))
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesRVHolder =
        ClassesRVHolder(ClassesRecycleItemBinding.inflate(LayoutInflater.from(parent.context),
        parent, false))

    override fun onBindViewHolder(holder: ClassesRVHolder, position: Int) =
        holder.setClassesInfo(dataSet[position])

    override fun getItemCount() = dataSet.size
}