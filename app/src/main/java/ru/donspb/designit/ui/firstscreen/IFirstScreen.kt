package ru.donspb.designit.ui.firstscreen

import ru.donspb.designit.model.ClassesModel

interface IFirstScreen {
    fun setTime(timeInMs: Long)
    fun setClassesData(data: List<ClassesModel>)
    fun setClassesRVTo(position: Int)
}