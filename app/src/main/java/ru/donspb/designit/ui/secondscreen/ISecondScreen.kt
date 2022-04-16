package ru.donspb.designit.ui.secondscreen

import ru.donspb.designit.model.ClassesModelExtended

interface ISecondScreen {
    fun setTimelineData(dataSet: List<ClassesModelExtended>)
    fun setClassesRVTo(position: Int?)
}