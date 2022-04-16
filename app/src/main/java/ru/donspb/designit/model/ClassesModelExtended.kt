package ru.donspb.designit.model

data class ClassesModelExtended(
    val classname: String,
    val timeStart: String,
    val timeEnd: String,
    val hasSkype: Boolean,
    val isMandatory: Boolean,
    val icon: String,
    val teacher: String,
    val about: String? = null
)
