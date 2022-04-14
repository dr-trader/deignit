package ru.donspb.designit.repository

import ru.donspb.designit.model.ClassesModel
import ru.donspb.designit.model.ClassesModelExtended
import ru.donspb.designit.model.HomeworksModel

interface IRepository {
    fun getClasses(): List<ClassesModel>
    fun getExtendedClasses(): List<ClassesModelExtended>
    fun getHomeworks(): List<HomeworksModel>
}