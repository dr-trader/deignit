package ru.donspb.designit.model

data class ClassesModel(
    val classname: String,
    val timeStart: String,
    val timeEnd: String,
    val hasSkype: Boolean,
    val isMandatory: Boolean,
    val icon: String
)
