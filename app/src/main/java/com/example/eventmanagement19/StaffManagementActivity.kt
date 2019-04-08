package com.example.eventmanagement19

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.eventmanagement19.Model.StaffList
import com.example.eventmanagement19.extensions.loadCurrentEventId
import com.example.eventmanagement19.extensions.loadCurrentEventName
import com.example.eventmanagement19.extensions.loadCurrentStudentId
import com.example.eventmanagement19.extensions.loadCurrentStudentName
import kotlinx.android.synthetic.main.activity_staff_management.RecyclerViewStaffManagement
import kotlinx.android.synthetic.main.activity_staff_management.student_header2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StaffManagementActivity : AppCompatActivity() {

    lateinit var currentStudentName: String
    lateinit var currentStudentId: String
    lateinit var currentEventId: String
    lateinit var currentEventName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_management)
        loadVars() // Loads lateinit variables from SharedPreferences

        student_header2.init(currentStudentName, currentEventName)
        loadStaffList()








    }

    private fun loadStaffList() {
        val client = RetrofitService().client
        val call = client.getStaffsByEventId(currentEventId.toLong())
        call.enqueue(object: Callback<StaffList> {
            override fun onFailure(call: Call<StaffList>, t: Throwable) {
                Toast.makeText(this@StaffManagementActivity, t.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<StaffList>, response: Response<StaffList>) {
                val staffList = response.body()
                RecyclerViewStaffManagement.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = StaffManagementAdapter(context, staffList!!) {
                    }
                }
            }
        })
    }

    fun onClickStaffManagement(v: View){
        //todo: new intent to add Staff
        intent = Intent(this, AddStaffActivity::class.java)
        startActivity(intent)
    }

    private fun loadVars() {
        currentStudentId = loadCurrentStudentId(this)
        currentStudentName = loadCurrentStudentName(this)
        currentEventId = loadCurrentEventId(this)
        currentEventName = loadCurrentEventName(this)
    }
    }

