package ru.donspb.designit.ui.firstscreen

import android.os.CountDownTimer
import ru.donspb.designit.repository.IRepository
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

const val MINUTE: Long = 1000 * 60
const val INTERVAL_FROM: Long = MINUTE * 60 * 24  // One day
const val INTERVAL_TO: Long = MINUTE * 60 * 72    // Three days

class FirstScreenPresenter(val firstScreenView: IFirstScreen, private val repository: IRepository) {


    fun countdown() {
        val time = Random.nextLong(INTERVAL_FROM, INTERVAL_TO)

        object: CountDownTimer(time, MINUTE) {
            override fun onTick(untilFinished: Long) {
                firstScreenView.setTime(untilFinished)
            }

            override fun onFinish() {
                firstScreenView.setTime(0L)
            }
        }.start()
    }

    fun getClasses() {
        var position: Int? = null
        val dataSet = repository.getClasses()
        val currentTime = LocalTime.now()
        var classTimeStart: LocalTime
        var classTimeEnd: LocalTime
        firstScreenView.setClassesData(dataSet)
        for (i in dataSet.indices) {
//            LocalTime.parse(dataSet[i].timeStart, DateTimeFormatter.ofPattern("H:mm"))
//                .also { classTimeStart = it }
            LocalTime.parse(dataSet[i].timeEnd, DateTimeFormatter.ofPattern("H:mm"))
                .also { classTimeEnd = it }
            if (currentTime < classTimeEnd) {
                position = i
                break
            }
        }
        firstScreenView.setClassesRVTo(position)
    }
}