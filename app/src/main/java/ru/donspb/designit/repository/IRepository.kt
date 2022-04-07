package ru.donspb.designit.repository

import ru.donspb.designit.model.ClassesModel
import ru.donspb.designit.model.HomeworksModel

interface IRepository {
    fun getClasses(): List<ClassesModel>
    fun getHomeworks(): List<HomeworksModel>
}