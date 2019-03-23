package com.example.eventmanagement19

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_organize_event.RecyclerViewOrganizeEvents
import CustomButtonAdapter
import android.content.Intent

class OrganizeEventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organize_event)

        val buttonList = ArrayList<CustomButton>()
        buttonList.add(CustomButton(R.drawable.ic_event_available_black_24dp, "Event Management", 0))
        buttonList.add(CustomButton(R.drawable.ic_event_available_black_24dp, "Staff Management", 1))
        buttonList.add(CustomButton(R.drawable.ic_event_available_black_24dp, "QR Code Check-In", 2))
        buttonList.add(CustomButton(R.drawable.ic_event_available_black_24dp, "Attendee Summary", 3))
        buttonList.add(CustomButton(R.drawable.ic_event_available_black_24dp, "Statistics", 4))




        RecyclerViewOrganizeEvents.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = CustomButtonAdapter(context, buttonList) {
                when (it.buttonId) {
                    2 -> startActivity(Intent(context, QrCodeCheckInActivity::class.java))
                }
            }
        }
    }
}
