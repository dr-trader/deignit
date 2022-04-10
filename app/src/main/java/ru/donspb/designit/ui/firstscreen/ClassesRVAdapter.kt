package ru.donspb.designit.ui.firstscreen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.donspb.designit.databinding.ClassesRecycleItemBinding
import ru.donspb.designit.model.ClassesModel

class ClassesRVAdapter() :
    RecyclerView.Adapter<ClassesRVAdapter.ClassesRVHolder>() {

    private val TYPE_ITEM1 = 0
    private val TYPE_ITEM2 = 1

    private var dataSet: MutableList<ClassesModel> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<ClassesModel>?) {
        if (!data.isNullOrEmpty()) {
            dataSet.clear()
            dataSet.addAll(data)
            notifyDataSetChanged()
        }
    }

    fun addNoClasses() {
        dataSet.add(ClassesModel("No more classes today",
            "-:-", "-:-", false, true, "infinity"))
        notifyItemInserted(itemCount - 1)
    }

    inner class ClassesRVHolder(private val binding: ClassesRecycleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setClassesInfo(data: ClassesModel) {
            binding.className.text = data.classname
            binding.classTime.text = "${data.timeStart} - ${data.timeEnd}"
            val context = binding.classesRvClassItem.ivIconClasses.context
            binding.classesRvClassItem.ivIconClasses.setImageResource(context.resources.getIdentifier(
                data.icon, "drawable", context.packageName))
            if (data.hasSkype) binding.skypeButton.visibility = View.VISIBLE
            else binding.skypeButton.visibility = View.GONE
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesRVHolder {
        return ClassesRVHolder(ClassesRecycleItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }


    override fun onBindViewHolder(holder: ClassesRVHolder, position: Int) =
        holder.setClassesInfo(dataSet[position])

    override fun getItemCount() = dataSet.size
}