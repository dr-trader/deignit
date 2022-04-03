package ru.donspb.designit

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBar.DISPLAY_SHOW_CUSTOM

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appActionBar = supportActionBar
//        val inflator: LayoutInflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val v: View = inflator.inflate(R.layout.top_text_layout, null)
        appActionBar?.apply {
            setDisplayShowTitleEnabled(false)
            setDisplayShowCustomEnabled(true)
//            customView = v
//            setDisplayOptions(DISPLAY_SHOW_CUSTOM)
//            setCustomView(R.layout.top_text_layout)
        }



//        val appBarTextView = TextView(this)
//        appBarTextView.apply {
//            setText("Activity")
//            setTextColor(getResources().getColor(R.color.light_gray))
//        }
//        appActionBar?.customView = appBarTextView


        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.main_container, FirstScreenFragment())
                .commit()
        }

    }
}