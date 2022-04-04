package ru.donspb.designit

import android.os.CountDownTimer
import java.time.LocalDateTime
import java.util.*

class FirstScreenPresenter(val firstScreenView: IFirstScreen) {

    private val FUTURE_DATE = 3

    fun countdown() {
        val time = 1000 * 60 * 60 * 72

        object: CountDownTimer(time.toLong(), 1000 * 60) {
            val timeController = false
            override fun onTick(untilFinished: Long) {
                firstScreenView.setTime(untilFinished)
            }

            override fun onFinish() {
                firstScreenView.setTime(0L)
            }
        }.start()
    }
}