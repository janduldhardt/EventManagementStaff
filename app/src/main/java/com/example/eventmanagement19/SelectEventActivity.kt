package com.example.eventmanagement19

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.eventmanagement19.extensions.loadCurrentStudentId
import kotlinx.android.synthetic.main.activity_select_event.student_header
import retrofit2.Retrofit

class SelectEventActivity : AppCompatActivity() {

    lateinit var currentStudentId: String
    val client = RetrofitService().client


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_event)
        currentStudentId = loadCurrentStudentId(this)
        student_header.init("Peter Zwegat", currentStudentId)
        loadEvents()

    }

    private fun loadEvents() {
        client.getStaffEventsByStudentId(currentStudentId)
    }

    fun onClickSelectEvent(v: View){
        val intent = Intent(this, OrganizeEventActivity::class.java)
        startActivity(intent)
    }
}
