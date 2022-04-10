package ru.donspb.designit.ui.firstscreen

import ru.donspb.designit.model.ClassesModel
import ru.donspb.designit.model.HomeworksModel

interface IFirstScreen {
    fun setTime(timeInMs: Long)
    fun setClassesData(data: List<ClassesModel>)
    fun setClassesRVTo(position: Int?)
    fun setHomeworksData(data: List<HomeworksModel>)
}