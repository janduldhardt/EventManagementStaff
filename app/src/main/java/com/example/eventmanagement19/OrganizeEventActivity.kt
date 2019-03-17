package com.example.eventmanagement19

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_organize_event.RecyclerViewOrganizeEvents
import CustomButtonAdapter

class OrganizeEventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organize_event)

        val buttonList  =  ArrayList<CustomButton>()
        buttonList.add(CustomButton(R.drawable.ic_event_available_black_24dp, "Event Management"))
        buttonList.add(CustomButton(R.drawable.ic_event_available_black_24dp, "Staff Management"))


                RecyclerViewOrganizeEvents.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = CustomButtonAdapter(context, buttonList)
                }

    }
}
