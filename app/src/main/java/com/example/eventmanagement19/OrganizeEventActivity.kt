package com.example.eventmanagement19

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_organize_event.RecyclerViewOrganizeEvents
import CustomButtonAdapter
import android.content.Intent
import com.example.eventmanagement19.Model.CustomButton
import com.example.eventmanagement19.R.drawable
import com.example.eventmanagement19.extensions.loadCurrentEventId
import com.example.eventmanagement19.extensions.loadCurrentEventName
import com.example.eventmanagement19.extensions.loadCurrentStudentId
import com.example.eventmanagement19.extensions.loadCurrentStudentName
import kotlinx.android.synthetic.main.activity_organize_event.student_header

class OrganizeEventActivity : AppCompatActivity() {

    lateinit var currentStudentName: String
    lateinit var currentStudentId: String
    lateinit var currentEventId: String
    lateinit var currentEventName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organize_event)
        loadVars() // Loads lateinit variables from SharedPreferences
        student_header.init(currentStudentName, currentEventName)

        val buttonList = ArrayList<CustomButton>()
        buttonList.add(
            CustomButton(
                drawable.ic_event_available_black_24dp, "Event Management", 0
            )
        )
        buttonList.add(
            CustomButton(
                drawable.ic_event_available_black_24dp,
                "Staff Management",
                1
            )
        )
        buttonList.add(
            CustomButton(
                drawable.ic_event_available_black_24dp,
                "QR Code Check-In",
                2
            )
        )
        buttonList.add(
            CustomButton(
                drawable.ic_event_available_black_24dp,
                "Attendee Summary",
                3
            )
        )
        buttonList.add(
            CustomButton(
                drawable.ic_event_available_black_24dp,
                "Statistics",
                4
            )
        )




        RecyclerViewOrganizeEvents.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = CustomButtonAdapter(context, buttonList) {
                when (it.buttonId) {
                    1 -> startActivity(Intent(context, StaffManagementActivity::class.java))
                    2 -> startActivity(Intent(context, QrCodeCheckInActivity::class.java))
                }
            }
        }
    }

    private fun loadVars() {
        currentStudentId = loadCurrentStudentId(this)
        currentStudentName = loadCurrentStudentName(this)
        currentEventId = loadCurrentEventId(this)
        currentEventName = loadCurrentEventName(this)
    }
}
