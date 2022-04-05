package ru.donspb.designit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.donspb.designit.ui.firstscreen.FirstScreenFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appActionBar = supportActionBar
        appActionBar?.apply {
            setDisplayShowTitleEnabled(false)
            setDisplayShowCustomEnabled(true)
        }

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.main_container, FirstScreenFragment())
                .commit()
        }

    }
}