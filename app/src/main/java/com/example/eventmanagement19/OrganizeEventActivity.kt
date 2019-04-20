package com.example.eventmanagement19

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_organize_event.RecyclerViewOrganizeEvents
import CustomButtonAdapter
import android.content.Intent
import com.example.eventmanagement19.Model.CustomButton
import com.example.eventmanagement19.R.drawable
import com.example.eventmanagement19.extensions.*
import kotlinx.android.synthetic.main.activity_organize_event.student_header

class OrganizeEventActivity : AppCompatActivity() {

    lateinit var currentStudentName: String
    lateinit var currentStudentId: String
    lateinit var currentEventId: String
    lateinit var currentEventName: String
    lateinit var currentOrganizerId: String

//    val id by lazy {
//        loadCurrentStudentId(this) //use this instead of lateinit var to create a val
//    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organize_event)
        loadVars() // Loads lateinit variables from SharedPreferences
        val buttonList = ArrayList<CustomButton>()

        if(currentOrganizerId != "-1") {

            student_header.init(currentStudentName, currentEventName)

            buttonList.add(
                    CustomButton(
                            drawable.ic_ticket, "Event Management", 0
                    )
            )
            buttonList.add(
                    CustomButton(
                            drawable.img_325788,
                            "Staff Management",
                            1
                    )
            )

            buttonList.add(
                    CustomButton(
                            drawable.ic_qr_code_scanner,
                            "QR Code Check-In",
                            2
                    )
            )

            buttonList.add(
                    CustomButton(
                            drawable.ic_attendee_summary,
                            "Attendee Summary",
                            3
                    )
            )
            buttonList.add(
                    CustomButton(
                            drawable.ic_statistics,
                            "Statistics",
                            4
                    )
            )
        } else {
            buttonList.add(
                    CustomButton(
                            drawable.ic_qr_code_scanner,
                            "QR Code Check-In",
                            2
                    )
            )
        }




        RecyclerViewOrganizeEvents.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = CustomButtonAdapter(context, buttonList) {
                when (it.buttonId) {
                    1 -> startActivity(Intent(context, StaffManagementActivity::class.java))
                    2 -> startActivity(Intent(context, QrCodeCheckInActivity::class.java))
                    3 -> startActivity(Intent(context, AttendeeSummaryActivity::class.java))
                    4 -> startActivity(Intent(context, StatisticsActivity::class.java))
                }
            }
        }
    }

    private fun loadVars() {
        currentStudentId = loadCurrentStudentId(this)
        currentStudentName = loadCurrentStudentName(this)
        currentEventId = loadCurrentEventId(this)
        currentEventName = loadCurrentEventName(this)
        currentOrganizerId = loadCurrentOrganizerId(this)
    }
}
