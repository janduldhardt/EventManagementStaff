package com.example.eventmanagement19

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.eventmanagement19.Model.StaffManagementItem
import kotlinx.android.synthetic.main.activity_organize_event.RecyclerViewOrganizeEvents
import kotlinx.android.synthetic.main.activity_staff_management.RecyclerViewStaffManagement

class StaffManagementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_management)

        val staffListTest = mutableListOf<StaffManagementItem>()
            staffListTest.add(StaffManagementItem("Sanpawat","6118123",222))
        staffListTest.add(StaffManagementItem("Sanpawasst","6128123",322))



        RecyclerViewStaffManagement.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = StaffManagementAdapter(context, staffListTest) {

                }
            }
        }

    fun onClickStaffManagement(v: View){
        //todo: new intent to add Staff
        intent = Intent(this, AddStaffActivity::class.java)
        startActivity(intent)
    }
    }

