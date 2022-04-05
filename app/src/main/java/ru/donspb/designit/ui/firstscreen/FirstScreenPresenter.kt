package ru.donspb.designit.ui.firstscreen

import android.os.CountDownTimer
import ru.donspb.designit.repository.FakeRepository
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

const val MINUTE: Long = 1000 * 60
const val INTERVAL_FROM: Long = MINUTE * 60 * 24  // One day
const val INTERVAL_TO: Long = MINUTE * 60 * 72    // Three days

class FirstScreenPresenter(val firstScreenView: IFirstScreen, val repository: FakeRepository) {


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
            classTimeStart = LocalTime.parse(dataSet[i].timeStart, DateTimeFormatter.ofPattern("H:mm"))
            classTimeEnd = LocalTime.parse(dataSet[i].timeEnd, DateTimeFormatter.ofPattern("H:mm"))
            if (currentTime.compareTo(classTimeStart) >= 0) {
                if (currentTime.compareTo(classTimeEnd) < 0) {
                    position = i
                    break
                }
            } else {
                position = i
                break
            }
        }
        if (position == null) firstScreenView.setClassesRVTo(null)
        else firstScreenView.setClassesRVTo(position)
    }
}