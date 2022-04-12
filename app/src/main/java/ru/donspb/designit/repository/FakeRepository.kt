package ru.donspb.designit.repository

import ru.donspb.designit.model.ClassesModel
import ru.donspb.designit.model.HomeworksModel

class FakeRepository : IRepository {

    override fun getClasses(): List<ClassesModel> =
        listOf(
            ClassesModel("History", "8:00", "8:45", true,
                true, "history", "Mrs.Thomas"),
            ClassesModel("Literature", "9:00", "9:45", false,
                true, "literature", "Mr.Barros"),
            ClassesModel("Physical Education", "10:00", "11:35", false,
                false, "sport", "Mr.Smith", "Preparing for olimpic games"),
            ClassesModel("Math", "12:00", "12:45", true,
                true, "maths", "Mr.Fibonacci"),
            ClassesModel("Chemistry", "13:00", "13:45", false,
                true, "chemistry", "Mrs.Mendeleeva"),
            ClassesModel("Programming", "14:00", "14:45", false,
                false, "programming", "Mr.C", "Preparing for interview for developer position")
        )

    override fun getHomeworks(): List<HomeworksModel> =
        listOf(
            HomeworksModel("Literature", "2", "Read scenes 1.1 - 1.12 of" +
                    " the Master and Margarita ", "literature"),
            HomeworksModel("Physics", "5", "Learn Newton's laws of motion",
                "chemistry"),
            HomeworksModel("Programming", "7", "Make interface for Kotlin application",
                "programming"),
        )

}