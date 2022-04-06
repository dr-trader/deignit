package ru.donspb.designit.repository

import ru.donspb.designit.model.ClassesModel

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
}