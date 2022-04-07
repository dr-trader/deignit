package ru.donspb.designit.repository

import ru.donspb.designit.model.ClassesModel
import ru.donspb.designit.model.HomeworksModel

class FakeRepository : IRepository {

    override fun getClasses(): List<ClassesModel> =
        listOf(
            ClassesModel("History", "8:00", "8:45", true,
                true, "history"),
            ClassesModel("Literature", "9:00", "9:45", false,
                true, "literature"),
            ClassesModel("Physical Education", "10:00", "11:35", false,
                false, "sport"),
            ClassesModel("Math", "12:00", "12:45", true,
                true, "maths"),
            ClassesModel("Chemistry", "13:00", "13:45", false,
                true, "chemistry"),
            ClassesModel("Programming", "14:00", "14:45", false,
                false, "programming")
        )

    override fun getHomeworks(): List<HomeworksModel> =
        listOf(
            HomeworksModel("Literature", "2", "Read scenes 1.1 - 1.12 of" +
                    " the Master and Margarita "),
            HomeworksModel("Physics", "5", "Learn Newton's laws of motion"),
            HomeworksModel("Programming", "7", "Make interface for Kotlin application"),
        )

}