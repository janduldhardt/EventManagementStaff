package com.example.eventmanagement19

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.AlertDialogLayout
import android.view.View
import kotlinx.android.synthetic.main.activity_add_staff.editText_studentId_addStaff

class AddStaffActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_staff)
    }

    fun onClickAddStaff(v:View){
        val studentId = editText_studentId_addStaff.text
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirm?")
            .setMessage("Are you sure to add $studentId as a staff member?")
            .setPositiveButton("Confirm"){dialog, it ->

    }
            .setNegativeButton("Dismiss"){dialog, which ->

            }
            .show()


    }
}
