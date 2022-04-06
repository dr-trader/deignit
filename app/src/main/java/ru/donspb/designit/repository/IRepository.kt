package ru.donspb.designit.repository

import ru.donspb.designit.model.ClassesModel

interface IRepository {
    fun getClasses(): List<ClassesModel>
}