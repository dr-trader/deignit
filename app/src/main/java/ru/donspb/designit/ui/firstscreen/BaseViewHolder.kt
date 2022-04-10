package ru.donspb.designit.ui.firstscreen

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<in T: Any>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}