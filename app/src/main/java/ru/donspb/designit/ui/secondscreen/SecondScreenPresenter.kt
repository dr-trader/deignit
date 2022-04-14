package ru.donspb.designit.ui.secondscreen

import android.os.Build
import androidx.annotation.RequiresApi
import ru.donspb.designit.repository.IRepository
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class SecondScreenPresenter(val secondScreenView: ISecondScreen, private val repository: IRepository) {

    @RequiresApi(Build.VERSION_CODES.O)
    fun getTimelineData() {
        var position: Int? = null
        val dataSet = repository.getExtendedClasses()
        val currentTime = LocalTime.now()
        var classTimeEnd: LocalTime
        secondScreenView.setTimelineData(dataSet)
        for (i in dataSet.indices) {
            LocalTime.parse(dataSet[i].timeEnd, DateTimeFormatter.ofPattern("H:mm"))
                .also { classTimeEnd = it }
            if (currentTime < classTimeEnd) {
                position = i
                break
            }
        }
        secondScreenView.setClassesRVTo(position)
    }
}