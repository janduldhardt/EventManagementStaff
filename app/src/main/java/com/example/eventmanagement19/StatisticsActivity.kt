package com.example.eventmanagement19

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.eventmanagement19.extensions.loadCurrentEventName
import kotlinx.android.synthetic.main.activity_statistics.*

class StatisticsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        student_header3.init(loadCurrentEventName(this), "Statistics" )


    }
}
