package com.example.eventmanagement19

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.AlertDialogLayout
import android.view.View
import android.widget.Toast
import com.example.eventmanagement19.Model.Staff
import com.example.eventmanagement19.extensions.loadCurrentEventId
import com.example.eventmanagement19.extensions.loadCurrentEventName
import com.example.eventmanagement19.extensions.loadCurrentOrganizerId
import com.example.eventmanagement19.extensions.loadCurrentStudentId
import com.example.eventmanagement19.extensions.loadCurrentStudentName
import kotlinx.android.synthetic.main.activity_add_staff.editText_studentId_addStaff
import kotlinx.android.synthetic.main.activity_add_staff.student_header
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddStaffActivity : AppCompatActivity() {

    lateinit var currentStudentName: String
    lateinit var currentStudentId: String
    lateinit var currentEventId: String
    lateinit var currentEventName: String
    lateinit var currentOrganizerId: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_staff)
        loadVars() // Loads lateinit variables from SharedPreferences

        student_header.init(currentStudentName, currentEventName)
    }

    fun onClickAddStaff(v:View){
        val studentId = editText_studentId_addStaff.text.toString().toLong()
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirm?")
            .setMessage("Are you sure to add $studentId as a staff member?")
            .setPositiveButton("Confirm"){dialog, it ->
                val newStaff = Staff(studentId, currentOrganizerId.toLong(), currentEventId.toLong()  )
            addStaffCall(newStaff)
    }
            .setNegativeButton("Dismiss"){dialog, which ->

            }
            .show()


    }

    private fun addStaffCall(newStaff : Staff) {
        val call = RetrofitService().client.addStaff(newStaff)
        call.enqueue(object : Callback<Void>{
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(this@AddStaffActivity, t.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Toast.makeText(this@AddStaffActivity, response.code().toString(), Toast.LENGTH_SHORT).show()
                editText_studentId_addStaff.setText("")
            }
        })
    }

    private fun loadVars() {
        currentStudentId = loadCurrentStudentId(this)
        currentStudentName = loadCurrentStudentName(this)
        currentEventId = loadCurrentEventId(this)
        currentEventName = loadCurrentEventName(this)
        currentOrganizerId = loadCurrentOrganizerId(this)
    }
}
